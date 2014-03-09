package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.User;

public class ReserveDAO {
	private DAOHelper helper;
	
	public void add(ActivityReserve reserve) {
		helper.save(reserve);
	}
	
	public void remove (ActivityReserve reserve) {
		helper.remove(reserve);
	}
	
	public ArrayList<ActivityReserve> find (User user) {
		ArrayList<SimpleExpression> expressions = new ArrayList<>();
		expressions.add(Restrictions.eq("user", user));
		@SuppressWarnings("unchecked")
		List<ActivityReserve> reserveList = helper.find(ActivityReserve.class, expressions);
		ArrayList<ActivityReserve> activityReserves = new ArrayList<>(reserveList);
		return activityReserves;
	}
	
	public ActivityReserve find (String userId, String activityId) {
		String hql = "from edu.nju.healthClub.model.ActivityReserve where userId = '" + userId + "' and activityId='" + activityId + "'";
		@SuppressWarnings("unchecked")
		List<ActivityReserve> activityReserves = helper.find(hql);
		ActivityReserve activityReserve = null;
		if (activityReserves.size() > 0) {
			activityReserve = activityReserves.get(0);
		}
		return activityReserve;
	}
	
	public ActivityReserve find (int id) {
		ActivityReserve reserve = (ActivityReserve)helper.findById(ActivityReserve.class, id);
		return reserve;
	}
	
	public long getMemberCount (String dateString) {
		String hql = "select count(*) from edu.nju.healthClub.model.ActivityReserve where date = '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Long> counts = helper.find(hql);
		if (counts.size() == 0) {
			return 0;
		}
		return counts.get(0);
	}
	
	public void setHelper(DAOHelper helper) {
		this.helper = helper;
	}
	
	
}
