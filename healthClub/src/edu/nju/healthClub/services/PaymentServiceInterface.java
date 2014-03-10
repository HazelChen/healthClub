package edu.nju.healthClub.services;

import edu.nju.healthClub.dao.PaymentDAOInterface;
import edu.nju.healthClub.model.PaymentRecords;

public interface PaymentServiceInterface {

	public abstract void add(PaymentRecords records);

	public abstract void setPaymentDAO(PaymentDAOInterface paymentDAO);

}