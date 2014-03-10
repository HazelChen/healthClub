package edu.nju.healthClub.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.healthClub.dao.ActivityDAOInterface;
import edu.nju.healthClub.dao.DAPHelperInterface;
import edu.nju.healthClub.model.Activity;
import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubPlaceColumn;

public class ActivityDAO implements ActivityDAOInterface {
	private DAPHelperInterface helper;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#findActivityByDate(java.lang.String)
	 */
	@Override
	public List<Activity> findActivityByDate (String dateString) {
		String hql = "from edu.nju.healthClub.model.Activity where date = '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Activity> list = helper.find(hql);
		return list;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#findActivityAfterDate(java.lang.String)
	 */
	@Override
	public List<Activity> findActivityAfterDate (String dateString) {
		String hql = "from edu.nju.healthClub.model.Activity where date >= '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Activity> list = helper.find(hql);
		return list;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#findActivityById(java.lang.String)
	 */
	@Override
	public Activity findActivityById (String id) {
		Activity activity = (Activity)helper.findById(Activity.class, id);
		return activity;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#getPlaceColumns(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<ClubPlaceColumn> getPlaceColumns (String firstDayString, String lastDayString) {
		String hql = "select place, count(*) " + 
				"from edu.nju.healthClub.model.Activity " + 
				"where date >='" + firstDayString + "' and date <'" + lastDayString + "' " + 
				"group by place";
		ArrayList<ClubPlaceColumn> clubPlaceColumns = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> rows = helper.find(hql);
		for (int i = 0; i < rows.size(); i++) {
			Object[] row = rows.get(i);
			long count = (Long)row[1];
			ClubPlaceColumn clubPlaceColumn = new ClubPlaceColumn((String)row[0], (int)count);
			clubPlaceColumns.add(clubPlaceColumn);
		}
		return clubPlaceColumns;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#getCoachColumns(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<ClubCoachColumn> getCoachColumns (String firstDayString, String lastDayString) {
		String hql = "select coach, count(*) " + 
				"from edu.nju.healthClub.model.Activity " + 
				"where date >='" + firstDayString + "' and date <'" + lastDayString + "' " + 
				"group by coach";
		ArrayList<ClubCoachColumn> clubCoachColumns = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> rows = helper.find(hql);
		for (int i = 0; i < rows.size(); i++) {
			Object[] row = rows.get(i);
			long count = (Long)row[1];
			ClubCoachColumn clubCoachColumn = new ClubCoachColumn((String)row[0], (int)count);
			clubCoachColumns.add(clubCoachColumn);
		}
		return clubCoachColumns;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#save(edu.nju.healthClub.model.Activity)
	 */
	@Override
	public void save(Activity activity) {
		helper.save(activity);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#update(edu.nju.healthClub.model.Activity)
	 */
	@Override
	public void update(Activity activity) {
		helper.update(activity);
	}

	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ActivityDAOInterface#setHelper(edu.nju.healthClub.dao.DAOHelper)
	 */
	@Override
	public void setHelper(DAPHelperInterface helper) {
		this.helper = helper;
	}
}
