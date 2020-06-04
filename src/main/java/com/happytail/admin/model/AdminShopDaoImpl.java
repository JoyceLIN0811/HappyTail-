package com.happytail.admin.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminShopDaoImpl implements AdminShopDao {

	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}
	
	@Override
	public Long countProjects() {
		String hql = "select count(*) from ProductBean";
		Query query = getSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	@Override
	public Long countOrders() {
		String hql = "select count(*) from OrderBean";
		Query query = getSession().createQuery(hql);
		return (Long)query.uniqueResult();
	}

	@Override
	public Long sumOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countProjectType() {
		// TODO Auto-generated method stub
		return null;
	}

}
