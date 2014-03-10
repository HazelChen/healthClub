package edu.nju.healthClub.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.nju.healthClub.dao.DAPHelperInterface;
import edu.nju.healthClub.model.ActivityReserve;

public class DAOHelper implements DAPHelperInterface {
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#find(java.lang.String)
	 */
	@Override
	public List find (String hql) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List list = query.list();
		
		session.close();
		sessionFactory.close();
		return list;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#findById(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public Object findById (Class className, Serializable id) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Object object = session.get(className, id);
		session.close();
		sessionFactory.close();
		return object;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#find(java.lang.Class, java.util.ArrayList)
	 */
	@Override
	public List find (Class className, ArrayList<SimpleExpression> expressions) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(className);
		for (int i = 0; i < expressions.size(); i++) {
			criteria.add(expressions.get(i));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List list = criteria.list();
		
		session.close();
		sessionFactory.close();
		return list;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#findAll(java.lang.Class)
	 */
	@Override
	public List findAll (Class className) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(className);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List list = criteria.list();
		session.close();
		sessionFactory.close();
		return list;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#save(java.lang.Object)
	 */
	@Override
	public void save(Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#update(java.lang.Object)
	 */
	@Override
	public void update(Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.dao.DAPHelperInterface#remove(java.lang.Object)
	 */
	@Override
	public void remove (Object object) {
		SessionFactory sessionFactory = buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(object);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	private SessionFactory buildSessionFactory() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
