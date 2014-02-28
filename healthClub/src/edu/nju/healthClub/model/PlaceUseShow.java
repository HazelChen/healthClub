package edu.nju.healthClub.model;

import java.util.Date;

public class PlaceUseShow {
	private String place;
	private String activityId;
	private String activityName;
	private Date activityDate;
	
	public PlaceUseShow (String place, String activityId, String activityName, Date activityDate) {
		this.place = place;
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityDate = activityDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	
	
}
