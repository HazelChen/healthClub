package edu.nju.healthClub.dao;

import edu.nju.healthClub.model.PaymentRecords;

public interface PaymentDAOInterface {

	public abstract void add(PaymentRecords records);

	public abstract void setHelper(DAPHelperInterface helper);

}