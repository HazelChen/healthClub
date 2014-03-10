package edu.nju.healthClub.services.impl;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.dao.ReserveDAOInterface;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.ClubMemberStatistics;
import edu.nju.healthClub.model.User;
import edu.nju.healthClub.services.ActivityServiceInterface;
import edu.nju.healthClub.services.DateChangeServiceInterface;
import edu.nju.healthClub.services.ReserveServiceInterface;
import edu.nju.healthClub.services.UserServiceInterface;

public class ReserveService implements ReserveServiceInterface {
	private UserServiceInterface userService;
	private ActivityServiceInterface activityService;
	private DateChangeServiceInterface dateChangeService;
	
	private ReserveDAOInterface reserveDAO;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#reserve(java.lang.String, java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#cancel(edu.nju.healthClub.model.ActivityReserve)
	 */
	@Override
	public void cancel (ActivityReserve reserve) {
		reserveDAO.remove(reserve);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#findByUser(edu.nju.healthClub.model.User)
	 */
	@Override
	public ArrayList<ActivityReserve> findByUser (User user) {
		ArrayList<ActivityReserve> reserves = reserveDAO.find(user);
		return reserves;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#find(int)
	 */
	@Override
	public ActivityReserve find(int reserveId) {
		return reserveDAO.find(reserveId);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#find(java.lang.String, java.lang.String)
	 */
	@Override
	public ActivityReserve find (String userId, String activityId) {
		ActivityReserve reserve = reserveDAO.find(userId, activityId);
		return reserve;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#getClubMemberStatistics(java.lang.String)
	 */
	@Override
	public ClubMemberStatistics getClubMemberStatistics (String dateString) {
		Calendar searchedCalendar = dateChangeService.getFirstDayCalendar(dateString);
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
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#setUserService(edu.nju.healthClub.services.impl.UserService)
	 */
	@Override
	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#setActivityService(edu.nju.healthClub.services.impl.ActivityServiceInterface)
	 */
	@Override
	public void setActivityService(ActivityServiceInterface activityService) {
		this.activityService = activityService;
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#setReserveDAO(edu.nju.healthClub.dao.ReserveDAO)
	 */
	@Override
	public void setReserveDAO(ReserveDAOInterface reserveDAO) {
		this.reserveDAO = reserveDAO;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.ReserveServiceInterface#setDateChangeService(edu.nju.healthClub.services.impl.DateChangeServiceInterface)
	 */
	@Override
	public void setDateChangeService(DateChangeServiceInterface dateChangeService) {
		this.dateChangeService = dateChangeService;
	}
}
