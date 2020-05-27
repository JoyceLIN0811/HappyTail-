package com.happytail.shopping.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.service.OrderService;

@Controller
public class ShowOrderS {
	@Autowired
	SessionFactory SessionFactory;
	
	@Autowired
	OrderService dao;
	
	
	public OrderBean show() {
		OrderBean selectOrder = dao.selectOrder(1);
		return null;
	}
}
