package com.happytail.forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ReplylistView;

@Repository
public class ReplylistViewDAOImpl implements ReplylistViewDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	private final String selectAllReply =
			"FROM com.happytail.forum.model.dao.ReplylistView WHERE topicId=:topicId ORDER BY createTime DESC";
	
	private final String AllReplyCounts = 
			"SELECT COUNT(*) FROM com.happytail.forum.model.ReplylistView";
	

	@Override
	public List<ReplylistView> select(int topicId) {
		Query<ReplylistView> query = getSession().createQuery(selectAllReply, ReplylistView.class);
		query.setParameter("topicId", topicId);
		List<ReplylistView> list = query.list();
		return list;
	}

	@Override
	public long AllReplyCounts(int topicId) {
		Query query = getSession().createQuery(AllReplyCounts);
		query.setParameter("topicId", topicId);
		long count = (long)query.uniqueResult();
		return count;
	}

}
