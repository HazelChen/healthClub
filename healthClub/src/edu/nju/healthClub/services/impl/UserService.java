package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.healthClub.dao.UserDAOInterface;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.MemberAgeStatistics;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.MemberSexStatistics;
import edu.nju.healthClub.model.MembershipStatistics;
import edu.nju.healthClub.model.MonthSelection;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.BankServiceInterface;
import edu.nju.healthClub.services.DateChangeServiceInterface;
import edu.nju.healthClub.services.PassportChangeServiceInterface;
import edu.nju.healthClub.services.PaymentServiceInterface;
import edu.nju.healthClub.services.UserServiceInterface;

public class UserService implements UserServiceInterface {
	private static final int PERSONAL_ACTIVE_PAYMENT = 75;
	private static final int FAMILY_ACTIVE_PAYMENT = 100;
	private static final int PERSONAL_MONTH_PAYMENT = 40;
	private static final int FAMILY_MONTH_PAYMENT = 55;
	private static final int CHILD_MONTH_PAYMENT = 10;
	private static final String MONTH_PAYMENT_REASON = "账户月缴费";
	private static final String ACTIVE_PAYMENT_REASON = "会员激活缴费";
	
	private UserDAOInterface userDAO;
	
	private BankServiceInterface bankService;
	private PaymentServiceInterface paymentService;
	private DateChangeServiceInterface dateChangeService;
	private PassportChangeServiceInterface passportChangeService;
	
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#save(edu.nju.healthClub.model.User)
	 */
	@Override
	public void save(User user) {
		String passport = user.getEmail();
		user.setResidence(passportChangeService.getResidence(passport));
		user.setSex(passportChangeService.getSex(passport));
		user.setBirth(passportChangeService.getBirth(passport));;
		userDAO.save(user);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#update(edu.nju.healthClub.model.User)
	 */
	@Override
	public void update(User user) {
		String passport = user.getEmail();
		user.setResidence(passportChangeService.getResidence(passport));
		user.setSex(passportChangeService.getSex(passport));
		user.setBirth(passportChangeService.getBirth(passport));;
		userDAO.update(user);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#find(java.lang.String)
	 */
	@Override
	public User find(String id) {
		User user = userDAO.find(id);
		return user;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#pay()
	 */
	@Override
	public void pay() {
		ArrayList<User> users = userDAO.findAll();
		for (User user : users) {
			Bank bank = user.getBank();
			if (bank != null) {
				int payCount = judgeMonthPayCount(user);
				PaymentRecords records = new PaymentRecords();
				records.setUser(user);
				records.setDate(Calendar.getInstance().getTime());
				records.setReason(MONTH_PAYMENT_REASON);
				boolean success = bankService.pay(bank, records,payCount);
				paymentService.add(records);
				
				paymentResultHandle(user, success);
				userDAO.update(user);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#activate(edu.nju.healthClub.model.User, java.lang.String)
	 */
	@Override
	public void activate (User user, String bankId) {
		Bank bank = bankService.find(bankId);
		user.setBank(bank);
		
		PaymentRecords records = new PaymentRecords();
		records.setUser(user);
		records.setDate(Calendar.getInstance().getTime());
		records.setReason(ACTIVE_PAYMENT_REASON);
		int payCount = judgeActivePayCount(user);
		boolean success = bankService.pay(bank, records, payCount);
		paymentService.add(records);
		
		paymentResultHandle(user, success);
		userDAO.update(user);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#getDuration(java.lang.String)
	 */
	@Override
	public ArrayList<MonthSelection> getDuration (String selectedMonth) {
		ArrayList<MonthSelection> monthSelections = new ArrayList<>();
		
		Date minDate = userDAO.getMinDateString();
		Calendar minCalendar = Calendar.getInstance();
		minCalendar.setTime(minDate);
		
		Calendar nowCalendar = Calendar.getInstance();
		while (nowCalendar.after(minCalendar)) {
			String monthString = nowCalendar.get(Calendar.YEAR) + "." + (nowCalendar.get(Calendar.MONTH) + 1);
			MonthSelection monthSelection = new MonthSelection(monthString, false);
			if (monthString.equals(selectedMonth)) {
				monthSelection.setSelected(true);
			}
			monthSelections.add(monthSelection);
			nowCalendar.add(Calendar.MONTH, -1);
		}
		return monthSelections;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#getMembershipStatistics(java.lang.String)
	 */
	@Override
	public MembershipStatistics getMembershipStatistics (String dateString) {
		Calendar calendar = dateChangeService.getFirstDayCalendar(dateString);
		String firstDayString = dateChangeService.normalDateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.normalDateToString(calendar.getTime());
		
		int newCount = (int)userDAO.getNewCount(firstDayString, lastDayString);
		int suspendCount = (int)userDAO.getSuspendCount(firstDayString, lastDayString);
		int stopCount = (int)userDAO.getStopCount(firstDayString, lastDayString);
		MembershipStatistics membershipStatistics = new MembershipStatistics(newCount, suspendCount, stopCount);
		return membershipStatistics;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#getMemberPlaceStatistics(java.lang.String)
	 */
	@Override
	public MemberPlaceStatistics getMemberPlaceStatistics (String dateString) {
		Calendar calendar = dateChangeService.getFirstDayCalendar(dateString);
		String firstDayString = dateChangeService.normalDateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.normalDateToString(calendar.getTime());
		
		MemberPlaceStatistics memberPlaceStatistics = userDAO.getMemberPlaceStatics(firstDayString, lastDayString);
		return memberPlaceStatistics;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#getMemberAgeStatistics(java.lang.String)
	 */
	@Override
	public MemberAgeStatistics getMemberAgeStatistics (String dateString) {
		Calendar calendar = dateChangeService.getFirstDayCalendar(dateString);
		String firstDayString = dateChangeService.normalDateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.normalDateToString(calendar.getTime());
		
		Calendar nowCalendar = Calendar.getInstance();
		int[] ageCount = new int[5];
		double totalCount = 0;
		for (int i = 0; i < ageCount.length; i++) {
			int maxYear = nowCalendar.get(Calendar.YEAR);
			nowCalendar.add(Calendar.YEAR, -20);
			int minYear = nowCalendar.get(Calendar.YEAR);
			ageCount[i] = (int)userDAO.getAgeCount(firstDayString, lastDayString, minYear, maxYear);
			totalCount += ageCount[i];
		}
		
		double[] agePercents = new double[5];
		for (int i = 0; i < ageCount.length; i++) {
			agePercents[i] = ageCount[i] / totalCount;
		}
		MemberAgeStatistics memberAgeStatistics = new MemberAgeStatistics(agePercents);
		return memberAgeStatistics;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#getMemberSexStatistics(java.lang.String)
	 */
	@Override
	public MemberSexStatistics getMemberSexStatistics(String dateString) {
		Calendar calendar = dateChangeService.getFirstDayCalendar(dateString);
		String firstDayString = dateChangeService.normalDateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.normalDateToString(calendar.getTime());
		
		int maleCount = (int) userDAO.getMaleCount(firstDayString,lastDayString);
		int femaleCount = (int) userDAO.getFemaleCount (firstDayString, lastDayString);
		MemberSexStatistics memberSexStatistics = new MemberSexStatistics(maleCount, femaleCount);
		return memberSexStatistics;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#setUserDAO(edu.nju.healthClub.dao.UserDAO)
	 */
	@Override
	public void setUserDAO(UserDAOInterface userDAO) {
		this.userDAO = userDAO;
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#setBankService(edu.nju.healthClub.services.impl.BankServiceInterface)
	 */
	@Override
	public void setBankService(BankServiceInterface bankService) {
		this.bankService = bankService;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#setPaymentService(edu.nju.healthClub.services.impl.PaymentServiceInterface)
	 */
	@Override
	public void setPaymentService(PaymentServiceInterface paymentService) {
		this.paymentService = paymentService;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#setDateChangeService(edu.nju.healthClub.services.impl.DateChangeServiceInterface)
	 */
	@Override
	public void setDateChangeService(DateChangeServiceInterface dateChangeService) {
		this.dateChangeService = dateChangeService;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.UserServiceInterface#setPassportChangeService(edu.nju.healthClub.services.impl.PassportChangeServiceInterface)
	 */
	@Override
	public void setPassportChangeService(PassportChangeServiceInterface passportChangeService) {
		this.passportChangeService = passportChangeService;
	}

	private int judgeMonthPayCount (User user) {
		String type = user.getType();
		if (type.equals("personal")) {
			return PERSONAL_MONTH_PAYMENT;
		} else {
			int childCount = user.getChildCount();
			return FAMILY_MONTH_PAYMENT + childCount * CHILD_MONTH_PAYMENT;
		}
	}
	
	private int judgeActivePayCount (User user) {
		String type = user.getType();
		if (type.equals("person")) {
			return PERSONAL_ACTIVE_PAYMENT;
		} else {
			return FAMILY_ACTIVE_PAYMENT;
		}
	}
	
	private void paymentResultHandle(User user, boolean success) {
		int suspendCount = user.getSuspendCount();
		if (success) {
			if (suspendCount != 0) {
				//重新恢复激活状态
				user.setSuspendCount(0);
				user.setSuspendDate(null);
				user.setStopDate(null);
			}
		} else {
			suspendCount++;
			if (suspendCount > 6) {
				//会员停止
				user.setBank(null);
				user.setSuspendCount(0);
				user.setSuspendDate(null);
				user.setStopDate(Calendar.getInstance().getTime());
			} else {
				if (suspendCount == 1) {
					user.setSuspendDate(Calendar.getInstance().getTime());
				}
				user.setSuspendCount(suspendCount);
			}
		}
	}
	
}
