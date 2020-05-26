package com.happytail.forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.TopiclistView;

@Repository
public class TopiclistViewDAOImpl implements TopiclistViewDAO {

	@Autowired
//	@Qualifier(value = "sessionfactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public TopiclistViewDAOImpl() {
		
	}

	private final String selectAllTopic = "FROM com.happytail.forum.model.TopiclistView ORDER BY createTime DESC";
	private final String SelectByCategoryId = "FROM com.happytail.forum.model.TopiclistView WHERE categoryId=:categoryId ORDER BY createTime DESC";
	private final String selectByMemberId = "FROM com.happytail.forum.model.TopiclistView WHERE memberId=:memberId ORDER BY createTime DESC";
	private final String AllTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView";
	private final String CategoryTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE categoryId=:categoryId";
	private final String MyTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE memberId=:memberId";

	@Override
	public List<TopiclistView> select() {
		List<TopiclistView> list = null;
		try {
			list = getSession().createQuery(selectAllTopic, TopiclistView.class).list();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public List<TopiclistView> selectByCategoryId(Integer categoryId) {
		List<TopiclistView> list = null;
		try {
			list = getSession().createQuery(SelectByCategoryId, TopiclistView.class)
					.setParameter("categoryId", categoryId).getResultList();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public List<TopiclistView> selectByMemberId(Integer memberId) {
		List<TopiclistView> list = null;
		try {
			list = getSession().createQuery(selectByMemberId, TopiclistView.class).setParameter("memberId", memberId)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public Long AllTopicCounts() {
		Long count = null;
		try {
			Query query = getSession().createQuery(AllTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long CategoryTopicCounts(Integer categoryId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(CategoryTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long MyTopicCounts(Integer memberId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(MyTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

}
