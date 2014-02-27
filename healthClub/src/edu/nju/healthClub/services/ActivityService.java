package edu.nju.healthClub.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.healthClub.dao.ActivityDAO;
import edu.nju.healthClub.model.Activity;

public class ActivityService {
	private ActivityDAO activityDAO;
	private DateChangeService dateChangeService;
	
	public ArrayList<Activity> nowadaysActivity () {
		ArrayList<Activity> result = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		for (int i = 0; i < 7; i++) {
			Date date = calendar.getTime();
			String dateString = dateChangeService.dateToString(date);
			List<Activity> activities = activityDAO.findActivityByDate(dateString);
			result.addAll(activities);
			calendar.add(Calendar.DATE, 1);
		}
		return result;
	}
	
	public void save(Activity activity) {
		activityDAO.save(activity);
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public void setDateChangeService(DateChangeService dateChangeService) {
		this.dateChangeService = dateChangeService;
	}
	
	
	
}
