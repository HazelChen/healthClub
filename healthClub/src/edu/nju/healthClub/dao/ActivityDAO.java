package edu.nju.healthClub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.nju.healthClub.model.Activity;

public class ActivityDAO {
	public List<Activity> findActivityByDate (String dateString) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		String hql = "from edu.nju.healthClub.model.Activity where date = '" + dateString + "'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Activity> list = query.list();
		session.close();
		sessionFactory.close();
		return list;
	}
	
	public void save(Activity activity) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(activity);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
