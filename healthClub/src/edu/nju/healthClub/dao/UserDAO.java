package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.nju.healthClub.model.MemberPlaceColumn;
import edu.nju.healthClub.model.MemberPlaceStatistics;
import edu.nju.healthClub.model.User;

public class UserDAO {
	private DAOHelper helper;
	
	public void save(User user) {
		helper.save(user);
	}
	
	public void update(User user) {
		helper.update(user);
	}
	
	public User find(String userId) {
		User user = (User)helper.findById(User.class, userId);
		return user;
	}
	
	public ArrayList<User> findAll () {
		@SuppressWarnings("unchecked")
		List<User> userList = helper.findAll(User.class);
		ArrayList<User> users = new ArrayList<>(userList);
		return users;
	}
	
	public Date getMinDateString () {
		String hql="select min(newDate) from edu.nju.healthClub.model.User";
		@SuppressWarnings("unchecked")
		List<Date> monthList = helper.find(hql);
		return monthList.get(0);
	}
	
	public long getNewCount(String firstDayString, String lastDayString) {
		String hql = "select count(*) from edu.nju.healthClub.model.User where newDate >= '" + firstDayString + "' and newDate < '" + lastDayString + "'";
		@SuppressWarnings("unchecked")
		List<Long> countList = helper.find(hql);
		if (countList.size() == 0) {
			return 0;
		}
		return countList.get(0);
	}
	
	public long getSuspendCount(String firstDayString, String lastDayString) {
		String hql = "select count(*) from edu.nju.healthClub.model.User where suspendDate >= '" + firstDayString + "' and suspendDate < '" + lastDayString + "'";
		@SuppressWarnings("unchecked")
		List<Long> countList = helper.find(hql);
		if (countList.size() == 0) {
			return 0;
		}
		return countList.get(0);
	}
	public long getStopCount(String firstDayString, String lastDayString) {
		String hql = "select count(*) from edu.nju.healthClub.model.User where stopDate >= '" + firstDayString + "' and stopDate < '" + lastDayString + "'";
		@SuppressWarnings("unchecked")
		List<Long> countList = helper.find(hql);
		if (countList.size() == 0) {
			return 0;
		}
		return countList.get(0);
	}
	
	public MemberPlaceStatistics getMemberPlaceStatics (String firstDayString, String lastDayString) {
		String hql = "select residence,count(*) from edu.nju.healthClub.model.User where newDate >= '" + firstDayString + "' and newDate < '" + lastDayString + "' group by residence";
		ArrayList<MemberPlaceColumn> columns = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Object[]> list = helper.find(hql);
		for (Iterator<Object[]> iterator = list.iterator();iterator.hasNext();) {
			Object[] object = (Object[])iterator.next();
			String place = (String)object[0];
			long count = (Long)object[1];
			MemberPlaceColumn column = new MemberPlaceColumn(place, (int)count);
			columns.add(column);
		}
		return new MemberPlaceStatistics(columns);
	}
	
	public long getAgeCount(String firstDayString, String lastDayString, int minYear, int maxYear) {
		String hql = "select count(*) from edu.nju.healthClub.model.User where newDate >= '" + firstDayString + "' and newDate < '" + lastDayString + "' and birth >= '" + minYear + "' and birth < '" + maxYear + "'";
		@SuppressWarnings("unchecked")
		List<Long> list = helper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	
	public long getMaleCount (String firstDayString, String lastDayString) {
		String hql = "select count(*) from edu.nju.healthClub.model.User where newDate >= '" + firstDayString + "' and newDate < '" + lastDayString + "' and sex='男'";
		@SuppressWarnings("unchecked")
		List<Long> list = helper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	
	public long getFemaleCount (String firstDayString, String lastDayString) {
		String hql = "select count(*) from edu.nju.healthClub.model.User where newDate >= '" + firstDayString + "' and newDate < '" + lastDayString + "' and sex='女'";
		@SuppressWarnings("unchecked")
		List<Long> list = helper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}

	public void setHelper(DAOHelper helper) {
		this.helper = helper;
	}
	
}
