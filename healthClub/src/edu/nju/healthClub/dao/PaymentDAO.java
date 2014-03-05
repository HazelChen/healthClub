package edu.nju.healthClub.dao;

import edu.nju.healthClub.model.PaymentRecords;

public class PaymentDAO {
	private DAOHelper helper;
	
	public void add(PaymentRecords records) {
		helper.save(records);
	}

	public void setHelper(DAOHelper helper) {
		this.helper = helper;
	}

	
}
