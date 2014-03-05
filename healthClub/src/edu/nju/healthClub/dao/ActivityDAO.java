package edu.nju.healthClub.dao;

import java.util.List;

import edu.nju.healthClub.model.Activity;

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
