package edu.nju.healthClub.dao.impl;

import edu.nju.healthClub.dao.DAPHelperInterface;
import edu.nju.healthClub.dao.PaymentDAOInterface;
import edu.nju.healthClub.model.PaymentRecords;

public class PaymentDAO implements PaymentDAOInterface {
	private DAPHelperInterface helper;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.PaymentDAOInterface#add(edu.nju.healthClub.model.PaymentRecords)
	 */
	@Override
	public void add(PaymentRecords records) {
		helper.save(records);
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.PaymentDAOInterface#setHelper(edu.nju.healthClub.dao.DAPHelperInterface)
	 */
	@Override
	public void setHelper(DAPHelperInterface helper) {
		this.helper = helper;
	}

	
}
