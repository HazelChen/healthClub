package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.model.AdminInfomation;
import edu.nju.healthClub.services.AdminVerificationServiceInterface;

public class AdminVerificationService implements AdminVerificationServiceInterface {
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.AdminVerificationServiceInterface#verificate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verificate(String id, String password) {
		AdminInfomation infomation = new AdminInfomation();
		if (id.equals(infomation.getId()) && password.equals(infomation.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
