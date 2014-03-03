package edu.nju.healthClub.services;

import edu.nju.healthClub.dao.PaymentDAO;
import edu.nju.healthClub.model.PaymentRecords;

public class PaymentService {
	private PaymentDAO paymentDAO;
	
	public void add(PaymentRecords records) {
		paymentDAO.add(records);
		System.out.println("添加付款记录");
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
}
