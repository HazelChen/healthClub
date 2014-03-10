package edu.nju.healthClub.services;

import java.util.ArrayList;

import edu.nju.healthClub.dao.ReserveDAOInterface;
import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.ClubMemberStatistics;
import edu.nju.healthClub.model.User;

public interface ReserveServiceInterface {

	public abstract void reserve(String userId, String activityId);

	public abstract void cancel(ActivityReserve reserve);

	public abstract ArrayList<ActivityReserve> findByUser(User user);

	public abstract ActivityReserve find(int reserveId);

	public abstract ActivityReserve find(String userId, String activityId);

	public abstract ClubMemberStatistics getClubMemberStatistics(
			String dateString);

	public abstract void setUserService(UserServiceInterface userService);

	public abstract void setActivityService(
			ActivityServiceInterface activityService);

	public abstract void setReserveDAO(ReserveDAOInterface reserveDAO);

	public abstract void setDateChangeService(
			DateChangeServiceInterface dateChangeService);

}