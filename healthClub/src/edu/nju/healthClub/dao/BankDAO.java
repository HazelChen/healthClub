package edu.nju.healthClub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.nju.healthClub.model.Bank;

public class BankDAO {
	
	public Bank find(String id) {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		String hql = "from edu.nju.healthClub.model.Bank where id = '" + id + "'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Bank> list = query.list();
		Bank bank = list.get(0);
		return bank;
	}
}
