package com.happytail.forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Favorate;
import com.happytail.forum.model.ThumbsUp;

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

	private final String selectByUserId = "SELECT categoryId FROM com.happytail.forum.model.Favorate WHERE userId=:userId";
	private final String selectByUserIdAndCategoryId = "FROM com.happytail.forum.model.Favorate WHERE userId=:userId AND categoryId=:categoryId";

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
	public boolean delete(Integer userId) {
		Favorate favorate = getSession().get(Favorate.class, userId);

		try {
			if (favorate != null) {
				getSession().delete(favorate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public Favorate selectByUserIdAndCategoryId(Integer userId, Integer categoryId) {
		Query<Favorate> check = getSession().createQuery(selectByUserIdAndCategoryId, Favorate.class);
		check.setParameter("userId", userId);
		check.setParameter("categoryId", categoryId);

		List<Favorate> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}

	@Override
	public List<Integer> selectCategoryIdList(Integer userId) {
		Query<Integer> check = getSession().createQuery(selectByUserId, Integer.class);
		check.setParameter("userId", userId);

		List<Integer> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list;
	}

	@Override
	public List<Favorate> selectFavorateCategoryList(Integer userId) {
		Query<Favorate> check = getSession().createQuery(selectByUserId, Favorate.class);
		check.setParameter("userId", userId);

		List<Favorate> list = check.list();
		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list;

	}

}