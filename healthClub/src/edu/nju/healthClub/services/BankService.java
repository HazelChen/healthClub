package edu.nju.healthClub.services;

import edu.nju.healthClub.dao.BankDAO;
import edu.nju.healthClub.model.Bank;

public class BankService {
	private BankDAO bankDAO;

	public Bank find (String id) {
		Bank bank = bankDAO.find(id);
		return bank;
	}
	
	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}
	
	
}
