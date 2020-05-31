package com.happytail.general.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Reply;
import com.happytail.general.model.Notice;

@Repository
public class NoticeDAO_impl implements NoticeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public NoticeDAO_impl() {

	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	private final String AllNotice = "FROM com.happytail.general.model.Notice ORDER BY createDate DESC";
	private final String SelectByModule = "FROM com.happytail.general.model.Notice WHERE module =: module ORDER BY createDate DESC";

	
	@Override
	public Notice insert(Notice notice) {
		try {
			if (notice != null) {
				getSession().save(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return notice;
	}

	@Override
	public boolean delete(Integer id) {
		Notice notice = getSession().get(Notice.class, id);
		try {
			if (notice != null) {
				getSession().delete(notice);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public Notice update(Notice notice) {
		try {
			if (notice != null) {
				getSession().update(notice);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return notice;
	}

	@Override
	public Notice select(Integer id) {
		Notice notice = null;

		try {
			notice = getSession().get(Notice.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return notice;
	}

	@Override
	public List<Notice> selectAll() {
		List<Notice> list = null;
		try {
			list = getSession().createQuery(AllNotice, Notice.class).list();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public List<Notice> selectByModule(String module) {
		Query<Notice> check = getSession().createQuery(SelectByModule, Notice.class);
		check.setParameter("module", module);

		List<Notice> list = check.list();
		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list;

	}

	@Override
	public Notice selectByUserId(Integer UserId) {

		Notice notice = null;
		try {
			notice = getSession().get(Notice.class, UserId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		return notice;
	}
		
	
	

}
