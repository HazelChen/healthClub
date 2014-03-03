package edu.nju.healthClub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.nju.healthClub.model.ActivityReserve;
import edu.nju.healthClub.model.User;

public class ReserveDAO {
	
	public void add(ActivityReserve reserve) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(reserve);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void remove (ActivityReserve reserve) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(reserve);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public ArrayList<ActivityReserve> find (User user) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(ActivityReserve.class);
		criteria.add(Restrictions.eq("user", user));
		@SuppressWarnings("unchecked")
		List<ActivityReserve> reserveList = criteria.list();
		ArrayList<ActivityReserve> activityReserves = new ArrayList<>(reserveList);
		return activityReserves;
	}
}
