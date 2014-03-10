package edu.nju.healthClub.services;

import java.util.ArrayList;

import edu.nju.healthClub.dao.ActivityDAOInterface;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubPlaceColumn;

public interface ActivityServiceInterface {

	public abstract ArrayList<Activity> getActivitiesAfterToday();

	public abstract ArrayList<Activity> recommand();

	public abstract ArrayList<Activity> findByDate(int year, int month, int date);

	public abstract ArrayList<ClubPlaceColumn> getPlaceColumns(String dateString);

	public abstract ArrayList<ClubCoachColumn> getCoachColumns(String dateString);

	public abstract Activity findById(String id);

	public abstract void save(Activity activity);

	public abstract void update(Activity activity);

	public abstract String generateId();

	public abstract void setActivityDAO(ActivityDAOInterface activityDAO);

	public abstract void setDateChangeService(
			DateChangeServiceInterface dateChangeService);

}