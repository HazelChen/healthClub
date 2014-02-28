package edu.nju.healthClub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.nju.healthClub.model.Bank;
import edu.nju.healthClub.model.User;

public class UserDAO {
	
	public void save(User user) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void update(User user) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public User find(String userId) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		User user = (User)session.get(User.class, userId);
		
		session.close();
		sessionFactory.close();
		return user;
	}
}
