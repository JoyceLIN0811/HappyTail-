package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Favorate;

@Repository
public class FavorateDAOImpl implements FavorateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public FavorateDAOImpl() {

	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Favorate insert(Favorate favorate) {
		try {
			if (favorate != null) {
				getSession().save(favorate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}
		return favorate;
	}

	@Override
	public boolean delete(Integer id) {
		Favorate favorate = getSession().get(Favorate.class, id);
		
		try {
			if(favorate != null) {
				getSession().delete(favorate);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public Favorate selectByUserId(Integer id) {
		if(id == null) {
			return null;
		}
		Favorate favorate = null;
		try {
			favorate = getSession().get(Favorate.class, id);
		}catch(NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		
		return favorate;
	}

}
