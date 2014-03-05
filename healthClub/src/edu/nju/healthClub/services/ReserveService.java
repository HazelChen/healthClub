package edu.nju.healthClub.services;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.dao.ReserveDAO;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.User;

public class ReserveService {
	private UserService userService;
	private ActivityService activityService;
	private ReserveDAO reserveDAO;
	
	public void reserve (String userId, String activityId) {
		ActivityReserve reserve = new ActivityReserve();
		User user = userService.find(userId);
		reserve.setUser(user);
		
		Activity activity = activityService.findById(activityId);
		reserve.setActivity(activity);
		
		Calendar calendar = Calendar.getInstance();
		reserve.setDate(calendar.getTime());
		
		reserveDAO.add(reserve);
	}
	
	public void cancel (ActivityReserve reserve) {
		reserveDAO.remove(reserve);
	}
	
	public ArrayList<ActivityReserve> findByUser (User user) {
		ArrayList<ActivityReserve> reserves = reserveDAO.find(user);
		return reserves;
	}
	
	public ActivityReserve find(int reserveId) {
		return reserveDAO.find(reserveId);
	}
	
	public ActivityReserve find (String userId, String activityId) {
		ActivityReserve reserve = reserveDAO.find(userId, activityId);
		return reserve;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

	public void setReserveDAO(ReserveDAO reserveDAO) {
		this.reserveDAO = reserveDAO;
	}
	
	
}
