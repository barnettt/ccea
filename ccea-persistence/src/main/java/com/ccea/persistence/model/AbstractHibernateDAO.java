package com.ccea.persistence.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract class providing implementation for some o the crud methods
 * 
 * @author abuayyub
 * 
 * @param <I>
 * @param <T>
 */
public abstract class AbstractHibernateDAO<T> implements CceaDAO<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444533786863905523L;

	private Class<T> type;

	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public AbstractHibernateDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		setType((Class<T>) pt.getActualTypeArguments()[0]);
	}

	protected String getClassName() {
		return type.getName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) sessionFactory.getCurrentSession()
				.createQuery("FROM " + type.getName()).list();
	}
	@Override
	public abstract T findById(Integer id);

	@Override
	public List<T> findByName(Map<String, String> field) {
		// List<T> userList = getHibernateTemplate().findByExample(u);
		// getHibernateTemplate().findByExample(u);;
		return null;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<T> findByObject(Integer obj) {
	//
	// return sessionFactory.getCurrentSession().load(type.getClass(), obj);
	//
	// }

	public void create(T obj) {

		sessionFactory.getCurrentSession().save(obj);
	}

	public void update(T obj) {
		sessionFactory.getCurrentSession().save(obj);
	}

	public void delete(T obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

}
