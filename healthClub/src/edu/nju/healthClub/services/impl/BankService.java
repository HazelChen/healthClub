package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.dao.BankDAOInterface;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.services.BankServiceInterface;

public class BankService implements BankServiceInterface {
	private BankDAOInterface bankDAO;

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.BankServiceInterface#find(java.lang.String)
	 */
	@Override
	public Bank find (String id) {
		Bank bank = bankDAO.find(id);
		return bank;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.BankServiceInterface#pay(edu.nju.healthClub.model.Bank, edu.nju.healthClub.model.PaymentRecords, int)
	 */
	@Override
	public boolean pay (Bank bank, PaymentRecords records, int amount) {
		boolean result = false;
		int balance = bank.getBalance();
		int over = balance - amount;
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
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.BankServiceInterface#setBankDAO(edu.nju.healthClub.dao.BankDAO)
	 */
	@Override
	public void setBankDAO(BankDAOInterface bankDAO) {
		this.bankDAO = bankDAO;
	}
	
	
}
