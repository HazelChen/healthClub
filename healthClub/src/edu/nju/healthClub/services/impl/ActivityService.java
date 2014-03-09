package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.healthClub.dao.ActivityDAO;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubPlaceColumn;

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
	
	public ArrayList<ClubPlaceColumn> getPlaceColumns (String dateString) {
		Calendar calendar = managerDateStringtoDate(dateString);
		String firstDayString = dateChangeService.dateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.dateToString(calendar.getTime());
		ArrayList<ClubPlaceColumn> columns = activityDAO.getPlaceColumns(firstDayString, lastDayString);
		return columns;
	}
	
	public ArrayList<ClubCoachColumn> getCoachColumns (String dateString) {
		Calendar calendar = managerDateStringtoDate(dateString);
		String firstDayString = dateChangeService.dateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.dateToString(calendar.getTime());
		ArrayList<ClubCoachColumn> columns = activityDAO.getCoachColumns(firstDayString, lastDayString);
		return columns;
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
	
	private Calendar managerDateStringtoDate (String dateString) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		if (dateString == null) {
			return calendar;
		}
		int year = Integer.parseInt(dateString.substring(0,4));
		int month = 0;
		if (dateString.length() > 6) {
			month = Integer.parseInt(dateString.substring(5,7));
		} else {
			month = Integer.parseInt(dateString.substring(5,6));
		}
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar;
	}
}
