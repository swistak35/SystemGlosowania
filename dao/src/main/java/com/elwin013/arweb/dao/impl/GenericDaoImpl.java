package com.elwin013.arweb.dao.impl;

import com.elwin013.arweb.dao.GenericDao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {
	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFACTORY) {
		sessionFactory = sessionFACTORY;
	}

	private Class<T> clazz;

	protected void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Transactional
	public void save(T obj) {
		getCurrentSession().save(obj);
	}

	@Transactional
	public void update(T obj) {
		getCurrentSession().update(obj);
	}

	@Transactional
	public void delete(T obj) {
		getCurrentSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T get(Integer id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	protected Session getCurrentSession() {
		if(sessionFactory.getCurrentSession() == null) {
			return sessionFactory.openSession();
		}
		else {
			return sessionFactory.getCurrentSession();
		}
			
	}

	@Transactional
	public void saveAll(Set<T> objects) {
		for (T object : objects) {
			save(object);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ArrayList<T> getAll() {
		ArrayList<T> list = (ArrayList<T>) getCurrentSession().createCriteria(this.clazz).list();
		return list;
	}

	@Transactional(readOnly = true)
	public int count() {
		return ((Long)getCurrentSession().createQuery("select count(*) from "+clazz.getCanonicalName()).uniqueResult()).intValue();
	}
}
