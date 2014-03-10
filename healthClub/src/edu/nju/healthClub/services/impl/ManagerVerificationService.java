package edu.nju.healthClub.services.impl;

import edu.nju.healthClub.model.ManagerInfomation;

public class ManagerVerificationService {

	/**
	 * @return true 验证成功
	 */
	public boolean verificate(String id, String password) {
		ManagerInfomation infomation = new ManagerInfomation();
		if (id.equals(infomation.getId()) && password.equals(infomation.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
