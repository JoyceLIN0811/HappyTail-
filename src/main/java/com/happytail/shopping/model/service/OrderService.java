package com.happytail.shopping.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.dao.OrderDao;



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

		return dao.insert(ob);
	}
	
	public List<OrderBean> selectOrderByMemberId(Integer memberId){
		return dao.selectOrderByMemberId(memberId);
	}
	
	public List<OrderItemBean> getOrderItemBean(OrderBean orderBean){
		return dao.getOrderItemBean(orderBean);
	}
	
}
