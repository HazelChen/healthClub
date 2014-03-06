package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.dao.PaymentDAO;
import edu.nju.healthClub.model.PaymentRecords;

public class PaymentService {
	private PaymentDAO paymentDAO;
	
	public void add(PaymentRecords records) {
		paymentDAO.add(records);
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
}
