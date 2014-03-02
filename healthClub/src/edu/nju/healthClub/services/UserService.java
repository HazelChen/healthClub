package edu.nju.healthClub.services;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.dao.UserDAO;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.model.User;

public class UserService {
	private static final int PERSONAL_MONTH_PAYMENT = 40;
	private static final int FAMILY_MONTH_PAYMENT = 55;
	private static final int CHILD_MONTH_PAYMENT = 10;
	private static final String PAYMENT_REASON = "账户月缴费";
	
	private BankService bankService;
	private PaymentService paymentService;
	
	private UserDAO userDAO;
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	public void update(User user) {
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
				int payCount = judgePayCount(user);
				PaymentRecords records = new PaymentRecords();
				records.setUser(user);
				records.setDate(Calendar.getInstance().getTime());
				records.setReason(PAYMENT_REASON);
				boolean success = bankService.pay(bank, records,payCount);
				paymentService.add(records);
				
				paymentResultHandle(user, success);
			}
		}
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

	private int judgePayCount (User user) {
		String type = user.getType();
		if (type.equals("personal")) {
			return PERSONAL_MONTH_PAYMENT;
		} else {
			int childCount = user.getChildCount();
			return FAMILY_MONTH_PAYMENT + childCount * CHILD_MONTH_PAYMENT;
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
			userDAO.update(user);
		}
	}
	
	
}
