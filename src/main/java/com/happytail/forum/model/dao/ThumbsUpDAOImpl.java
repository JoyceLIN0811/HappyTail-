package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.Topic;

@Repository
public class ThumbsUpDAOImpl implements ThumbsUpDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public ThumbsUpDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public ThumbsUp insert(ThumbsUp thumbsUp) {
		try {
			if (thumbsUp != null) {
				getSession().save(thumbsUp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return thumbsUp;
	}

	@Override
	public boolean delete(Integer id) {
		ThumbsUp thumbsUp = getSession().get(ThumbsUp.class, id);
		try {
			if (thumbsUp != null) {
				getSession().delete(thumbsUp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;

	}

	@Override
	public ThumbsUp update(ThumbsUp thumbsUp) {
		try {
			if (thumbsUp != null) {
				getSession().update(thumbsUp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return thumbsUp;
	}

	@Override
	public ThumbsUp select(Integer id) {
		ThumbsUp thumbsUp = getSession().get(ThumbsUp.class, id);
		try {
			thumbsUp = getSession().get(ThumbsUp.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return thumbsUp;
	}

}
