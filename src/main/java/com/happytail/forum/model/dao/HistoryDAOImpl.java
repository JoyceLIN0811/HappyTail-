package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.History;

@Repository
public class HistoryDAOImpl implements HistoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HistoryDAOImpl() {
		
	}
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	

	@Override
	public History insert(History history) {
		try {
			if (history != null) {
				getSession().save(history);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return history;
	}


	@Override
	public boolean delete(Integer id) {
		History history = getSession().get(History.class, id);
		try {
			if (history != null) {
				getSession().delete(history);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public History select(Integer id) {
		if(id == null) {
			return null;
		}
		History history = null;
		try {
			history = getSession().get(History.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return history;
	}


}
