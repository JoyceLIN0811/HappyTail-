package com.happytail.forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ReportlistView;

@Repository
public class ReportlistViewDAOImpl implements ReportlistViewDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public ReportlistViewDAOImpl() {
		
	}
	
	private final String selectAllReport = "FROM com.happytail.forum.model.ReportlistView ORDER BY createTime DESC";
	private final String ReportCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.ReportlistVie";
	
	@Override
	public List<ReportlistView> select() {
		List<ReportlistView> list = null;
		try {
			list = getSession().createQuery(selectAllReport, ReportlistView.class).list();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public Long Counts() {
		Long count = null;
		try {
			Query query = getSession().createQuery(ReportCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

}
