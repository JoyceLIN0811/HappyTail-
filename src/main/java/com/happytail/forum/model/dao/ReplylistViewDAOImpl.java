package com.happytail.forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ReplylistView;

@Repository
public class ReplylistViewDAOImpl implements ReplylistViewDAO{

	@Autowired
//	@Qualifier(value = "sessionfactory")
	private SessionFactory sessionfactory;
	
	public Session getSession() {
		Session session = sessionfactory.getCurrentSession();
		return session;
	}
	
	private final String selectAllReply =
			"FROM com.happytail.forum.model.dao.ReplylistView WHERE topicId=:topicId ORDER BY createTime DESC";
	
	private final String AllReplyCounts = 
			"SELECT COUNT(*) FROM com.happytail.forum.model.ReplylistView";
	

	@Override
	public List<ReplylistView> select(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long AllReplyCounts(int topicId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
