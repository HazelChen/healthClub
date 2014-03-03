package edu.nju.healthClub.services;

import edu.nju.healthClub.dao.BankDAO;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.PaymentRecords;

public class BankService {
	private BankDAO bankDAO;

	public Bank find (String id) {
		Bank bank = bankDAO.find(id);
		return bank;
	}
	
	public boolean pay (Bank bank, PaymentRecords records, int amount) {
		boolean result = false;
		int balance = bank.getBalance();
		int over = balance - amount;
		System.out.println("剩余款:" + over);
		if (over < 0) {
			bank.setBalance(0);
			records.setCount(balance);
			result = false;
		} else {
			bank.setBalance(over);
			records.setCount(amount);
			result = true;
		}
		bankDAO.update(bank);
		return result;
	}
	
	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}
	
	
}
