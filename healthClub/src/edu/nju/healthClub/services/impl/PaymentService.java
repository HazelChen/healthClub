package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.dao.PaymentDAOInterface;
import edu.nju.healthClub.model.PaymentRecords;
import edu.nju.healthClub.services.PaymentServiceInterface;

public class PaymentService implements PaymentServiceInterface {
	private PaymentDAOInterface paymentDAO;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.PaymentServiceInterface#add(edu.nju.healthClub.model.PaymentRecords)
	 */
	@Override
	public void add(PaymentRecords records) {
		paymentDAO.add(records);
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.PaymentServiceInterface#setPaymentDAO(edu.nju.healthClub.dao.PaymentDAO)
	 */
	@Override
	public void setPaymentDAO(PaymentDAOInterface paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
}
