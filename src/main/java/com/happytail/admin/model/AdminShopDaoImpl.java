package com.happytail.admin.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.dao.ProductDao;

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
	public Double sumOrders() {
		String sql = "select sum(totalPrice) from Orders where state = '完成'";
		Query query = getSession().createSQLQuery(sql);
		
		return (Double) query.uniqueResult();
	}
	
	//未處理訂單數
	@Override
	public Long unCheckOrders() {
		String hql = "select count(o.state) from OrderBean o where state = '已付款'";
		Query query = getSession().createQuery(hql);
		return (Long)query.uniqueResult();
	}

	@Override
	public Long countProductType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBean changeOrderStatus(Integer id) {
		Query<OrderBean> query = getSession().createQuery("From OrderBean o where o.orderId=:id",OrderBean.class);
		query.setParameter("id", id);
		OrderBean order = (OrderBean) query.uniqueResult();
		
		if(order != null) {			
				order.setState("完成");
				getSession().update(order);
		}
		return order;
		
		
	}

	@Override
	public List<OrderBean> adminAllOrders() {
		return null;
	}

	//每月銷售額
	@Override
	public List<Long> sumOrdersByMonth() {
		String sql = "select sum(totalPrice) as total from Orders "
				+ "where orderDate between '2019/01/01' and '2019/12/31' "
				+ "group by MONTH(orderDate)";
		Query<Long> query = getSession().createSQLQuery(sql);
		List<Long> list = query.getResultList();
		return list;
	}

	@Override
	public List<OrderBean> unCheckOrderList() {
		String hql = "From OrderBean o where o.state='已付款'";
		Query<OrderBean> query = getSession().createQuery(hql);
		List<OrderBean> list = query.getResultList();
		return list;
	}

	@Override
	public ProductBean updateProduct(ProductBean product) {
		
		ProductBean newProduct = getSession().get(ProductBean.class, product.getProductId());
		
		if(newProduct != null) {
			newProduct.setName(product.getName());	//更新商品名稱
			newProduct.setAmount(product.getAmount());
			newProduct.setCategoryId(product.getCategoryId());
			newProduct.setCoverImage(product.getCoverImage());
			newProduct.setDescriptrion(product.getDescriptrion());
			newProduct.setFileName(product.getFileName());
			newProduct.setStatus(product.getStatus());
			
			getSession().update(newProduct);
		}
		
		return product;
	}

	@Override
	public List<OrderBean> orderItemByOrderId(Integer id) {
		return null;
	}




}
