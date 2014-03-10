package edu.nju.healthClub.dao;

import java.util.ArrayList;

import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.User;

public interface ReserveDAOInterface {

	public abstract void add(ActivityReserve reserve);

	public abstract void remove(ActivityReserve reserve);

	public abstract ArrayList<ActivityReserve> find(User user);

	public abstract ActivityReserve find(String userId, String activityId);

	public abstract ActivityReserve find(int id);

	public abstract long getMemberCount(String dateString);

	public abstract void setHelper(DAPHelperInterface helper);

}