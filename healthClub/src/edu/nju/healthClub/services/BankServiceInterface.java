package edu.nju.healthClub.services;

import edu.nju.healthClub.dao.BankDAOInterface;
import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.PaymentRecords;

public interface BankServiceInterface {

	public abstract Bank find(String id);

	public abstract boolean pay(Bank bank, PaymentRecords records, int amount);

	public abstract void setBankDAO(BankDAOInterface bankDAO);

}