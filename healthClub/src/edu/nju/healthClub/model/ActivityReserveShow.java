package edu.nju.healthClub.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityReserveShow {
	private String activityId;
	private String name;
	private Date reserveDate;
	private Date date;
	
	public ActivityReserveShow(String activityId, String name, Date reserveDate, Date date) {
		this.activityId = activityId;
		this.name = name;
		this.reserveDate = reserveDate;
		this.date = date;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReserveDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateShort = dateFormat.format(reserveDate);
		return dateShort;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateShort = dateFormat.format(date);
		return dateShort;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
