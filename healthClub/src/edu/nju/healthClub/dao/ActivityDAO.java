package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.List;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubPlaceColumn;

public class ActivityDAO {
	private DAOHelper helper;
	
	public List<Activity> findActivityByDate (String dateString) {
		String hql = "from edu.nju.healthClub.model.Activity where date = '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Activity> list = helper.find(hql);
		return list;
	}
	
	public List<Activity> findActivityAfterDate (String dateString) {
		String hql = "from edu.nju.healthClub.model.Activity where date >= '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Activity> list = helper.find(hql);
		return list;
	}
	
	public Activity findActivityById (String id) {
		Activity activity = (Activity)helper.findById(Activity.class, id);
		return activity;
	}
	
	public ArrayList<ClubPlaceColumn> getPlaceColumns (String firstDayString, String lastDayString) {
		String hql = "select place, count(*) " + 
				"from edu.nju.healthClub.model.Activity " + 
				"where date >='" + firstDayString + "' and date <'" + lastDayString + "' " + 
				"group by place";
		ArrayList<ClubPlaceColumn> clubPlaceColumns = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> rows = helper.find(hql);
		for (int i = 0; i < rows.size(); i++) {
			Object[] row = rows.get(i);
			long count = (Long)row[1];
			ClubPlaceColumn clubPlaceColumn = new ClubPlaceColumn((String)row[0], (int)count);
			clubPlaceColumns.add(clubPlaceColumn);
		}
		return clubPlaceColumns;
	}
	
	public ArrayList<ClubCoachColumn> getCoachColumns (String firstDayString, String lastDayString) {
		String hql = "select coach, count(*) " + 
				"from edu.nju.healthClub.model.Activity " + 
				"where date >='" + firstDayString + "' and date <'" + lastDayString + "' " + 
				"group by coach";
		ArrayList<ClubCoachColumn> clubCoachColumns = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> rows = helper.find(hql);
		for (int i = 0; i < rows.size(); i++) {
			Object[] row = rows.get(i);
			long count = (Long)row[1];
			ClubCoachColumn clubCoachColumn = new ClubCoachColumn((String)row[0], (int)count);
			clubCoachColumns.add(clubCoachColumn);
		}
		return clubCoachColumns;
	}
	
	public void save(Activity activity) {
		helper.save(activity);
	}
	
	public void update(Activity activity) {
		helper.update(activity);
	}

	public void setHelper(DAOHelper helper) {
		this.helper = helper;
	}
}
