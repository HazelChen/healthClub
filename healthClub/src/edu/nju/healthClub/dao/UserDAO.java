package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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

	public void setHelper(DAOHelper helper) {
		this.helper = helper;
	}
	
}
