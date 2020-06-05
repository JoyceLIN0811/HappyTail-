package com.happytail.admin.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.shopping.model.OrderBean;

@Repository
public class AdminShopDaoImpl implements AdminShopDao {

	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}
	
	@Override
	public Long countProjects() {
		String hql = "select count(*) from ProductBean";
		Query query = getSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	@Override
	public Long countOrders() {
		String hql = "select count(*) from OrderBean";
		Query query = getSession().createQuery(hql);
		return (Long)query.uniqueResult();
	}

	@Override
	public Long sumOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countProjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBean changeOrderStatus(Integer id) {
		return null;
		
		
	}

	@Override
	public List<String> adminAllOrders() {
		String sql = "select o.orderId, p.username, o.totalPrice, o.orderDate, o.text, o.state from Orders o left join PetMembers p on  o.memberId = p.id";
		Query<String> query = getSession().createSQLQuery(sql);
		List<String> list = query.getResultList();
		return list;
	}

}
