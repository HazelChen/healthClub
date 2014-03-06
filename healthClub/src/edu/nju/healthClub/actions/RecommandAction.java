package edu.nju.healthClub.actions;

import java.io.IOException;
import java.util.Calendar;
import java.util.ArrayList;

import javax.servlet.ServletException;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.impl.ActivityService;

public class RecommandAction extends BaseAction{
	private static final long serialVersionUID = 1574319825950215251L;
	
	private ArrayList<Activity> recommandActivities;
	
	private ActivityService activityService;
	
	@Override
	public String execute () throws ServletException, IOException{
		this.recommandActivities = activityService.recommand();
		return SUCCESS;
	}

	public ArrayList<Activity> getRecommandActivities () {
		return recommandActivities;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	
	
}
