package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.dao.ReserveDAO;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubMemberStatistics;
import edu.nju.healthClub.model.ClubPlaceColumn;
import edu.nju.healthClub.model.User;

public class ReserveService {
	private UserService userService;
	private ActivityService activityService;
	private DateChangeService dateChangeService;
	
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
	
	public ClubMemberStatistics getClubMemberStatistics (String dateString) {
		Calendar searchedCalendar = managerDateStringtoDate(dateString);
		int totalCount = 0;
		int[] dayMemberCount = new int[searchedCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)];
		for (int i = 0; i < dayMemberCount.length; i++) {
			String searchedDateString = dateChangeService.normalDateToString(searchedCalendar.getTime());
			int dayCount = (int)reserveDAO.getMemberCount (searchedDateString);
			dayMemberCount[i] = dayCount;
			searchedCalendar.add(Calendar.DATE, 1);
			totalCount += dayCount;
		}
		return new ClubMemberStatistics(dayMemberCount, totalCount);
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
