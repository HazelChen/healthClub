package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.services.ActivityServiceInterface;

public class ActivityAction extends BaseAction{
	private static final long serialVersionUID = -8934726765255655806L;
	
	private ArrayList<Activity> activities;
	
	private ActivityServiceInterface service;
	
	/**
	 * 根据请求的日期获取活动数据
	 */
	public String getActivityByDate () {
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int date = Integer.parseInt(request.getParameter("date"));
		
		this.activities = service.findByDate(year, month, date);
		return SUCCESS;
	}
	
	/**
	 * 获取管理员需要看到的活动们
	 */
	public String getActivity () {
		activities = service.getActivitiesAfterToday();
		return SUCCESS;
	}
	
	public String getActivityById () {
		String id = request.getParameter("id");
		
		Activity activity = service.findById(id);
		this.activities = new ArrayList<>();
		this.activities.add(activity);
		return SUCCESS;
	}

	public ArrayList<Activity> getActivities () {
		return activities;
	}
	
	public void setService(ActivityServiceInterface service) {
		this.service = service;
	}
}
