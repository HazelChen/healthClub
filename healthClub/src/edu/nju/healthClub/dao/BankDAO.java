package edu.nju.healthClub.dao;

import edu.nju.healthClub.model.Bank;

public class BankDAO {
	private DAOHelper helper;
	
	public Bank find(String id) {
		Bank bank = (Bank)helper.findById(Bank.class, id);
		return bank;
	}
	
	public void update (Bank bank) {
		helper.update(bank);
	}

	public void setHelper(DAOHelper helper) {
		this.helper = helper;
	}
	
	
	                                                                                                    
}
