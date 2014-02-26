package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import edu.nju.healthClub.model.Activity;

public class ActivityDAO {
	private DAOHelper helper;
	
	public List<Activity> findActivityByDate (String dateString) {
		String query = "from edu.nju.healthClub.model.Activity where date = '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Activity> activities = helper.getList(query);
		return activities;
	}
}
