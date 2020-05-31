package com.happytail.forum.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	private final String selectTopicIsThumbsUp =
			"FROM com.happytail.forum.model.ThumbsUp WHERE topicId=:topicId and userId=:userId"; 
	private final String selectReplyIsThumbsUp =
			"FROM com.happytail.forum.model.ThumbsUp WHERE topicId=:topicId and userId=:userId and replyId=: replyId"; 
	private final String selectTopicIdList =
			"SELECT topicId FROM com.happytail.forum.model.ThumbsUp WHERE userId=:userId and type='topic'"; 



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
	public ThumbsUp selectByTopic(Integer topicId, Integer userId) {
		Query<ThumbsUp> check = getSession().createQuery(selectTopicIsThumbsUp, ThumbsUp.class);
		check.setParameter("topicId", topicId);
		check.setParameter("userId", userId);
		
		List<ThumbsUp> list = check.list();
		
		if(list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}
	
	@Override
	public ThumbsUp selectByReply(Integer topicId, Integer replyId,Integer userId) {
		Query<ThumbsUp> check = getSession().createQuery(selectReplyIsThumbsUp, ThumbsUp.class);
		check.setParameter("topicId", topicId);
		check.setParameter("replyId", replyId);
		check.setParameter("userId", userId);
		
		List<ThumbsUp> list = check.list();
		
		if(list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}

	@Override
	public List<Integer> selectTopicIdList(Integer userId, String type) {
		Query<Integer> check = getSession().createQuery(selectTopicIdList,Integer.class);
		check.setParameter("userId", userId);
		check.setParameter("type", type);
		
		List<Integer> list = check.list();
		
		if(list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list;
	}		
	

}
