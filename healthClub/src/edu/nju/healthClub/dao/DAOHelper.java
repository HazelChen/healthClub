package edu.nju.healthClub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class DAOHelper {
	
	public List findByHql (String hql) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List list = query.list();
		
		session.close();
		sessionFactory.close();
		return list;
	}
}
