package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.User;

public interface UserDAOInterface {

	public abstract void save(User user);

	public abstract void update(User user);

	public abstract User find(String userId);

	public abstract ArrayList<User> findAll();

	public abstract Date getMinDateString();

	public abstract long getNewCount(String firstDayString, String lastDayString);

	public abstract long getSuspendCount(String firstDayString,
			String lastDayString);

	public abstract long getStopCount(String firstDayString,
			String lastDayString);

	public abstract MemberPlaceStatistics getMemberPlaceStatics(
			String firstDayString, String lastDayString);

	public abstract long getAgeCount(String firstDayString,
			String lastDayString, int minYear, int maxYear);

	public abstract long getMaleCount(String firstDayString,
			String lastDayString);

	public abstract long getFemaleCount(String firstDayString,
			String lastDayString);

	public abstract void setHelper(DAPHelperInterface helper);

}