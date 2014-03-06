package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.healthClub.dao.ActivityDAO;
import edu.nju.healthClub.model.Activity;

public class ActivityService {
	private ActivityDAO activityDAO;
	private DateChangeService dateChangeService;
	
	public ArrayList<Activity> getActivitiesAfterToday() {
		ArrayList<Activity> result = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateString = dateChangeService.dateToString(date);
		List<Activity> activities = activityDAO.findActivityAfterDate(dateString);
		result.addAll(activities);
		return result;
	}
	
	public ArrayList<Activity> recommand () {
		ArrayList<Activity> result = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateString = dateChangeService.dateToString(date);
		List<Activity> activities = activityDAO.findActivityAfterDate(dateString);
		
		int index = 0;
		while (result.size() < 5 && index < activities.size()) {
			result.add(activities.get(index));
			index++;
		}
		return result;
	}
	
	public ArrayList<Activity> findByDate(int year, int month, int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date);
		String dateString = dateChangeService.dateToString(calendar.getTime());
		List<Activity> list = activityDAO.findActivityByDate(dateString);
		ArrayList<Activity> activities = new ArrayList<>();
		activities.addAll(list);
		return activities;
	}
	
	public Activity findById(String id) {
		Activity activity = activityDAO.findActivityById(id);
		return activity;
	}
	
	public void save(Activity activity) {
		activityDAO.save(activity);
	}
	
	public void update(Activity activity) {
		activityDAO.update(activity);
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public void setDateChangeService(DateChangeService dateChangeService) {
		this.dateChangeService = dateChangeService;
	}
	
	
	
}
