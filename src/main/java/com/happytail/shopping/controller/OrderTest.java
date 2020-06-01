package com.happytail.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.service.OrderService;

@Controller
public class OrderTest {
	@Autowired	
	SessionFactory sessionFactory;
	@Autowired
	OrderService Odao;
	
	@GetMapping("/selectAllOders")
	public String selectAllOders(Model m,		
			HttpServletRequest res) {
		PetMembers member =(PetMembers) res.getSession().getAttribute("LoginOK");
		
		List<OrderBean> list = Odao.selectOrderByMemberId(member.getId());
		m.addAttribute("list", list);
		System.out.println("list="+list);
		return "AllOrderList";
	}
	
	
	@GetMapping("/selectAllOdersT")
	public ResponseEntity<List<OrderItemBean>> selectAllOdersT(Model m,	
			@RequestParam("index") Integer index,
			HttpServletRequest res) {
//		PetMembers member =(PetMembers) res.getSession().getAttribute("LoginOK");
		System.out.println("進入con");
		Integer a = 1;
		List<OrderBean> list = Odao.selectOrderByMemberId(a);
		System.out.println("取得list");
		OrderBean orderBean = list.get(0);
		
		List<OrderItemBean> orderItemBean = Odao.getOrderItemBean(orderBean);
		String orderDate = orderItemBean.get(0).getOrderBean().getOrderDate();
		
		System.out.println(orderDate);
		ResponseEntity< List<OrderItemBean>> re 
		=new ResponseEntity<List<OrderItemBean>>(orderItemBean, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/selectOders")
	public ResponseEntity<List<OrderBean>> selectAllOders(Model m,	
			@RequestParam("index") Integer index,
			HttpServletRequest res) {

		System.out.println("進入con");
		Integer a = 1;
		List<OrderBean> list = Odao.selectOrderByMemberId(a);
		System.out.println("取得list");

		ResponseEntity< List<OrderBean>> re 
		=new ResponseEntity<List<OrderBean>>(list, HttpStatus.OK);
		return re;
	}
	
	
	
	
	
}
