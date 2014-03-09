package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.healthClub.dao.UserDAO;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.MemberAgeStatistics;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.MemberSexStatistics;
import edu.nju.healthClub.model.MembershipStatistics;
import edu.nju.healthClub.model.MonthSelection;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;

public class UserService {
	private static final int PERSONAL_ACTIVE_PAYMENT = 75;
	private static final int FAMILY_ACTIVE_PAYMENT = 100;
	private static final int PERSONAL_MONTH_PAYMENT = 40;
	private static final int FAMILY_MONTH_PAYMENT = 55;
	private static final int CHILD_MONTH_PAYMENT = 10;
	private static final String MONTH_PAYMENT_REASON = "账户月缴费";
	private static final String ACTIVE_PAYMENT_REASON = "会员激活缴费";
	
	private UserDAO userDAO;
	
	private BankService bankService;
	private PaymentService paymentService;
	private DateChangeService dateChangeService;
	private PassportChangeService passportChangeService;
	
	
	public void save(User user) {
		String passport = user.getEmail();
		user.setResidence(passportChangeService.getResidence(passport));
		user.setSex(passportChangeService.getSex(passport));
		user.setBirth(passportChangeService.getBirth(passport));;
		userDAO.save(user);
	}
	
	public void update(User user) {
		String passport = user.getEmail();
		user.setResidence(passportChangeService.getResidence(passport));
		user.setSex(passportChangeService.getSex(passport));
		user.setBirth(passportChangeService.getBirth(passport));;
		userDAO.update(user);
	}
	
	public User find(String id) {
		User user = userDAO.find(id);
		return user;
	}
	
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
	
	public MembershipStatistics getMembershipStatistics (String dateString) {
		Calendar calendar = managerDateStringtoDate(dateString);
		String firstDayString = dateChangeService.dateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.dateToString(calendar.getTime());
		int newCount = (int)userDAO.getNewCount(firstDayString, lastDayString);
		int suspendCount = (int)userDAO.getSuspendCount(firstDayString, lastDayString);
		int stopCount = (int)userDAO.getStopCount(firstDayString, lastDayString);
		MembershipStatistics membershipStatistics = new MembershipStatistics(newCount, suspendCount, stopCount);
		return membershipStatistics;
	}
	
	public MemberPlaceStatistics getMemberPlaceStatistics (String dateString) {
		Calendar calendar = managerDateStringtoDate(dateString);
		String firstDayString = dateChangeService.dateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.dateToString(calendar.getTime());
		MemberPlaceStatistics memberPlaceStatistics = userDAO.getMemberPlaceStatics(firstDayString, lastDayString);
		return memberPlaceStatistics;
	}
	
	public MemberAgeStatistics getMemberAgeStatistics (String dateString) {
		Calendar calendar = managerDateStringtoDate(dateString);
		String firstDayString = dateChangeService.dateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.dateToString(calendar.getTime());
		
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
	
	public MemberSexStatistics getMemberSexStatistics(String dateString) {
		Calendar calendar = managerDateStringtoDate(dateString);
		String firstDayString = dateChangeService.dateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.dateToString(calendar.getTime());
		
		int maleCount = (int) userDAO.getMaleCount(firstDayString,lastDayString);
		int femaleCount = (int) userDAO.getFemaleCount (firstDayString, lastDayString);
		MemberSexStatistics memberSexStatistics = new MemberSexStatistics(maleCount, femaleCount);
		return memberSexStatistics;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}
	
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void setDateChangeService(DateChangeService dateChangeService) {
		this.dateChangeService = dateChangeService;
	}
	
	public void setPassportChangeService(PassportChangeService passportChangeService) {
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
	
	private Calendar managerDateStringtoDate (String dateString) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		if (dateString == null) {
			return calendar;
		}
		int year = Integer.parseInt(dateString.substring(0,4));
		int month = 0;
		if (dateString.length() > 6) {
			month = Integer.parseInt(dateString.substring(5,7));
		} else {
			month = Integer.parseInt(dateString.substring(5,6));
		}
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar;
	}
}
