package edu.nju.healthClub.services;

import edu.nju.healthClub.model.AdminInfomation;

public class AdminVerificationService {
	
	/**
	 * @return true 验证成功
	 */
	public boolean verificate(String id, String password) {
		AdminInfomation infomation = new AdminInfomation();
		if (id.equals(infomation.getId()) && password.equals(infomation.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
