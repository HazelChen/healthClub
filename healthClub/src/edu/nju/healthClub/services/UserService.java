package edu.nju.healthClub.services;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.dao.UserDAO;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;

public class UserService {
	private static final int PERSONAL_ACTIVE_PAYMENT = 75;
	private static final int FAMILY_ACTIVE_PAYMENT = 100;
	private static final int PERSONAL_MONTH_PAYMENT = 40;
	private static final int FAMILY_MONTH_PAYMENT = 55;
	private static final int CHILD_MONTH_PAYMENT = 10;
	private static final String MONTH_PAYMENT_REASON = "账户月缴费";
	private static final String ACTIVE_PAYMENT_REASON = "账户月缴费";
	
	private BankService bankService;
	private PaymentService paymentService;
	
	private UserDAO userDAO;
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	public void update(User user) {
		userDAO.update(user);
	}
	
	public void merge(User user) {
		userDAO.merge(user);
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
		paymentResultHandle(user, success);
		userDAO.merge(user);
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
		if (type.equals("personal")) {
			return PERSONAL_ACTIVE_PAYMENT;
		} else {
			return FAMILY_ACTIVE_PAYMENT;
		}
	}
	
	private void paymentResultHandle(User user, boolean success) {
		int suspendCount = user.getSuspendCount();
		if (success) {
			if (suspendCount != 0) {
				user.setSuspendCount(0);
				userDAO.update(user);
			}
		} else {
			suspendCount++;
			if (suspendCount > 6) {
				user.setBank(null);
				user.setSuspendCount(0);
			} else {
				user.setSuspendCount(suspendCount);
			}
		}
	}
	
	
}
