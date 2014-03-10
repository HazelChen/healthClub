package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.List;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubPlaceColumn;

public interface ActivityDAOInterface {

	public abstract List<Activity> findActivityByDate(String dateString);

	public abstract List<Activity> findActivityAfterDate(String dateString);

	public abstract Activity findActivityById(String id);

	public abstract ArrayList<ClubPlaceColumn> getPlaceColumns(
			String firstDayString, String lastDayString);

	public abstract ArrayList<ClubCoachColumn> getCoachColumns(
			String firstDayString, String lastDayString);

	public abstract void save(Activity activity);

	public abstract void update(Activity activity);

	public abstract void setHelper(DAPHelperInterface helper);

}