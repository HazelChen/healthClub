package edu.nju.healthClub.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.SimpleExpression;

public interface DAPHelperInterface {

	public abstract List find(String hql);

	public abstract Object findById(Class className, Serializable id);

	public abstract List find(Class className,
			ArrayList<SimpleExpression> expressions);

	public abstract List findAll(Class className);

	public abstract void save(Object object);

	public abstract void update(Object object);

	public abstract void remove(Object object);

}