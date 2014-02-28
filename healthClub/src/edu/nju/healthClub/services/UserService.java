package edu.nju.healthClub.services;

import edu.nju.healthClub.dao.UserDAO;
import edu.nju.healthClub.model.User;

public class UserService {
	private UserDAO userDAO;
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	public void update(User user) {
		userDAO.update(user);
	}
	
	public User find(String id) {
		User user = userDAO.find(id);
		return user;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
