package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Report;

@Repository
public class ReportDAOImpl implements ReportDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public ReportDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Report insert(Report report) {
		try {
			if (report != null) {
				getSession().save(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return report;
	}

	@Override
	public Report update(Report report) {
		try {
			if (report != null) {
				getSession().update(report);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return report;
	}


	@Override
	public Report select(Integer id) {
		if(id == null) {
			return null;
		}
		Report report = null;
		try {
			report = getSession().get(Report.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return report;
	}

}
