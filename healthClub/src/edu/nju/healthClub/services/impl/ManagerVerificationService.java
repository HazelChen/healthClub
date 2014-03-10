package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.model.ManagerInfomation;
import edu.nju.healthClub.services.ManagerVerificationInterface;

public class ManagerVerificationService implements ManagerVerificationInterface {

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ManagerVerificationInterface#verificate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verificate(String id, String password) {
		ManagerInfomation infomation = new ManagerInfomation();
		if (id.equals(infomation.getId()) && password.equals(infomation.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
