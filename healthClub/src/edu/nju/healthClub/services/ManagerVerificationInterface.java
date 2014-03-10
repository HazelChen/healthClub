package edu.nju.healthClub.services;

public interface ManagerVerificationInterface {

	/**
	 * @return true 验证成功
	 */
	public abstract boolean verificate(String id, String password);

}