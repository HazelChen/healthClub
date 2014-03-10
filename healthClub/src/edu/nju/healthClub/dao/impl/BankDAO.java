package edu.nju.healthClub.dao.impl;

import edu.nju.healthClub.dao.BankDAOInterface;
import edu.nju.healthClub.dao.DAPHelperInterface;
import edu.nju.healthClub.model.Bank;

public class BankDAO implements BankDAOInterface {
	private DAPHelperInterface helper;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.BankDAOInterface#find(java.lang.String)
	 */
	@Override
	public Bank find(String id) {
		Bank bank = (Bank)helper.findById(Bank.class, id);
		return bank;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.BankDAOInterface#update(edu.nju.healthClub.model.Bank)
	 */
	@Override
	public void update (Bank bank) {
		helper.update(bank);
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.BankDAOInterface#setHelper(edu.nju.healthClub.dao.DAOHelper)
	 */
	@Override
	public void setHelper(DAPHelperInterface helper) {
		this.helper = helper;
	}
	
	
	                                                                                                    
}
