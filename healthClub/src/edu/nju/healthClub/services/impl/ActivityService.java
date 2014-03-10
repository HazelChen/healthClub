package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.healthClub.dao.ActivityDAOInterface;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubPlaceColumn;
import edu.nju.healthClub.services.ActivityServiceInterface;
import edu.nju.healthClub.services.DateChangeServiceInterface;

public class ActivityService implements ActivityServiceInterface {
	private ActivityDAOInterface activityDAO;
	
	private DateChangeServiceInterface dateChangeService;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#getActivitiesAfterToday()
	 */
	@Override
	public ArrayList<Activity> getActivitiesAfterToday() {
		ArrayList<Activity> result = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateString = dateChangeService.normalDateToString(date);
		List<Activity> activities = activityDAO.findActivityAfterDate(dateString);
		
		result.addAll(activities);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#recommand()
	 */
	@Override
	public ArrayList<Activity> recommand () {
		ArrayList<Activity> result = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateString = dateChangeService.normalDateToString(date);
		List<Activity> activities = activityDAO.findActivityAfterDate(dateString);
		
		int index = 0;
		while (result.size() < 5 && index < activities.size()) {
			result.add(activities.get(index));
			index++;
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#findByDate(int, int, int)
	 */
	@Override
	public ArrayList<Activity> findByDate(int year, int month, int date) {
		int calendarMonth = month - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, calendarMonth, date);
		String dateString = dateChangeService.normalDateToString(calendar.getTime());
		List<Activity> list = activityDAO.findActivityByDate(dateString);
		
		ArrayList<Activity> activities = new ArrayList<>();
		activities.addAll(list);
		return activities;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#getPlaceColumns(java.lang.String)
	 */
	@Override
	public ArrayList<ClubPlaceColumn> getPlaceColumns (String dateString) {
		Calendar calendar = dateChangeService.getFirstDayCalendar(dateString);
		String firstDayString = dateChangeService.normalDateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.normalDateToString(calendar.getTime());
		
		ArrayList<ClubPlaceColumn> columns = activityDAO.getPlaceColumns(firstDayString, lastDayString);
		return columns;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#getCoachColumns(java.lang.String)
	 */
	@Override
	public ArrayList<ClubCoachColumn> getCoachColumns (String dateString) {
		Calendar calendar = dateChangeService.getFirstDayCalendar(dateString);
		String firstDayString = dateChangeService.normalDateToString(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String lastDayString = dateChangeService.normalDateToString(calendar.getTime());
		
		ArrayList<ClubCoachColumn> columns = activityDAO.getCoachColumns(firstDayString, lastDayString);
		return columns;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#findById(java.lang.String)
	 */
	@Override
	public Activity findById(String id) {
		Activity activity = activityDAO.findActivityById(id);
		return activity;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#save(edu.nju.healthClub.model.Activity)
	 */
	@Override
	public void save(Activity activity) {
		activityDAO.save(activity);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#update(edu.nju.healthClub.model.Activity)
	 */
	@Override
	public void update(Activity activity) {
		activityDAO.update(activity);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#generateId()
	 */
	@Override
	public String generateId () {
		return "A" + System.currentTimeMillis();
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#setActivityDAO(edu.nju.healthClub.dao.ActivityDAO)
	 */
	@Override
	public void setActivityDAO(ActivityDAOInterface activityDAO) {
		this.activityDAO = activityDAO;
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ActivityServiceInterface#setDateChangeService(edu.nju.healthClub.services.impl.DateChangeService)
	 */
	@Override
	public void setDateChangeService(DateChangeServiceInterface dateChangeService) {
		this.dateChangeService = dateChangeService;
	}
}
