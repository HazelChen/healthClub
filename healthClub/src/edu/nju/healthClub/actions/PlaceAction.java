package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.impl.ActivityService;

public class PlaceAction extends BaseAction{
	private static final long serialVersionUID = -7452893292012390954L;
	
	private ArrayList<Activity> activities;
	
	private ActivityService activityService;
	
	@Override
	public String execute() {
		activities = activityService.getActivitiesAfterToday();
		return SUCCESS;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	
	
}
