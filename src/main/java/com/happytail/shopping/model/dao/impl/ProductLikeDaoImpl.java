package com.happytail.shopping.model.dao.impl;



import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.dao.ProductLikeDao;

@Repository
public class ProductLikeDaoImpl implements ProductLikeDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ServletContext context;
	
	@Override
	public Session s() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String  insert ( ProductLike pLike) {
		
		s().save(pLike);
		System.out.println("成功");
		return "加入成功";
	}

	@Override
	public Boolean delete(ProductLike pLike) {
		try {
			s().delete(pLike);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("沒有此收藏");
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProductLike> showLikes(Integer memberId){
		String newid = String.valueOf(memberId);
		String hql ="from  ProductLike where productLikeId=:memberId";
		Query<ProductLike> createQuery = s().createQuery(hql, ProductLike.class);
		createQuery.setParameter("memberId", newid);
		return createQuery.getResultList();
	}
	
}
