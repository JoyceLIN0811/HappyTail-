package com.happytail.shopping.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytail.shopping.dao.OrderDao;
import com.happytail.shopping.model.OrderBean;



@Service
@Transactional
public class OrderService {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	OrderDao dao;
	
	public OrderBean selectOrder(int orderId) {
		return dao.selectOrder( orderId);
	}
	
	public List<OrderBean> selectAllOrder(){
		return dao.selectAllOrder();
	}
	//查詢訂單 依照單一時間
	public List<OrderBean> selectOrderByTime(String time){
		return dao.selectOrderByTime(time);
	}
	
	public String cancel(int orderId) {
		return dao.cancel(orderId);
	}
	
	public String complete(int orderId) {
		return dao.complete(orderId);
	}
	
	public String overtime(int orderId) {
		return dao.overtime(orderId);
	}
	
	public long selectOrderByCount(Integer memberId) {
		return dao.selectOrderByCount(memberId);
	
	}
	
	public List<OrderBean> getAllOrderJson(){
		return dao.getAllOrderJson();
	}
	
	public String insert(OrderBean ob) {
		Session session = sessionFactory.getCurrentSession();
//		Set<OrderDetailBean> orderDetail = ob.getOrderDetail();
		System.out.println("進去Service");
//		System.out.println("orderDetail="+orderDetail);
//		for(OrderDetailBean:orderDetail) {
//			
//		}
		return dao.insert(ob);
	}
	
	public List<OrderBean> selectOrderByMemberId(Integer memberId){
		return dao.selectOrderByMemberId(memberId);
	}
	
	
	
}
