package com.happytail.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.happytail.shopping.model.CartBean;

//放棄購買
@Controller
public class AbortController {
	@Autowired
	SessionFactory	 sessionFactory;
	
	
	
	@GetMapping("/abortBuy")
	public String abortBuy(Model m,HttpServletRequest request) {
		HttpSession session = request.getSession();
		CartBean cart = (CartBean) session.getAttribute("cart");
		if(cart==null) {
			System.out.println("無購物車商品");
			return "showProduct";
		}
		request.removeAttribute("cart");
		return "showProduct";
	}
	
}
