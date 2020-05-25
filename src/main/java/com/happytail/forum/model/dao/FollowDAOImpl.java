package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Follow;
import com.happytail.forum.model.ThumbsUp;

@Repository
public class FollowDAOImpl implements FollowDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public FollowDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	
	@Override
	public Follow insert(Follow follow) {
		try {
			if (follow != null) {
				getSession().save(follow);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return follow;
	}


	@Override
	public boolean delete(Integer id) {
		Follow follow = getSession().get(Follow.class, id);
		try {
			if (follow != null) {
				getSession().delete(follow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;

	}

	@Override
	public Follow update(Follow follow) {
		try {
			if (follow != null) {
				getSession().update(follow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return follow;
	}

	@Override
	public Follow select(Integer id) {
		Follow follow = getSession().get(Follow.class, id);
		try {
			follow = getSession().get(Follow.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return follow;
	}

}
