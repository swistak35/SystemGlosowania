package com.mkyong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mkyong.common.Stock;

public class StockDaoImpl implements StockDao {

	private SessionFactory sessionFactory;
	
	@Override
	public void save(Stock stock) {
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(stock);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> list() {
		Session session = this.getSessionFactory().openSession();
		List<Stock> stockList = session.createQuery("from Stock").list();
		session.close();
		return stockList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
