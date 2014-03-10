package edu.nju.healthClub.services;

public interface PassportChangeServiceInterface {

	public abstract String getResidence(String passcode);

	public abstract String getSex(String passcode);

	public abstract int getBirth(String passcode);

}