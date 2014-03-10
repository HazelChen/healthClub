package edu.nju.healthClub.dao;

import edu.nju.healthClub.model.Bank;

public interface BankDAOInterface {

	public abstract Bank find(String id);

	public abstract void update(Bank bank);

	public abstract void setHelper(DAPHelperInterface helper);

}