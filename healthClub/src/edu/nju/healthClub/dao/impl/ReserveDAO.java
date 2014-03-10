package edu.nju.healthClub.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.healthClub.dao.DAPHelperInterface;
import edu.nju.healthClub.dao.ReserveDAOInterface;
import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.User;

public class ReserveDAO implements ReserveDAOInterface {
	private DAPHelperInterface helper;
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#add(edu.nju.healthClub.model.ActivityReserve)
	 */
	@Override
	public void add(ActivityReserve reserve) {
		helper.save(reserve);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#remove(edu.nju.healthClub.model.ActivityReserve)
	 */
	@Override
	public void remove (ActivityReserve reserve) {
		helper.remove(reserve);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#find(edu.nju.healthClub.model.User)
	 */
	@Override
	public ArrayList<ActivityReserve> find (User user) {
		ArrayList<SimpleExpression> expressions = new ArrayList<>();
		expressions.add(Restrictions.eq("user", user));
		@SuppressWarnings("unchecked")
		List<ActivityReserve> reserveList = helper.find(ActivityReserve.class, expressions);
		ArrayList<ActivityReserve> activityReserves = new ArrayList<>(reserveList);
		return activityReserves;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#find(java.lang.String, java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#find(int)
	 */
	@Override
	public ActivityReserve find (int id) {
		ActivityReserve reserve = (ActivityReserve)helper.findById(ActivityReserve.class, id);
		return reserve;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#getMemberCount(java.lang.String)
	 */
	@Override
	public long getMemberCount (String dateString) {
		String hql = "select count(*) from edu.nju.healthClub.model.ActivityReserve where date = '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Long> counts = helper.find(hql);
		if (counts.size() == 0) {
			return 0;
		}
		return counts.get(0);
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.ReserveDAOInterface#setHelper(edu.nju.healthClub.dao.DAPHelperInterface)
	 */
	@Override
	public void setHelper(DAPHelperInterface helper) {
		this.helper = helper;
	}
	
	
}
