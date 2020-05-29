package com.happytail.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.happytail.shopping.model.CartBean;
import com.happytail.shopping.service.ProductService;

@Controller
public class UpdateCartController {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	 ProductService dao ;
	
		@PostMapping("/UpateProduct")
		public String UpateProduct(Model m ,HttpServletRequest request) {
			HttpSession session = request.getSession();
			CartBean cart = (CartBean) session.getAttribute("cart");
			// 如果找不到購物車，沒有必要往下執行
			if(cart==null) {
				return "showProduct";
			}
			String cmd=(String) m.getAttribute("cmd");
			Integer productId = (Integer)m.getAttribute("productId");
			if (cmd.equalsIgnoreCase("DEL")) {
				cart.deleteProduct(productId);
				return "showCart";
			}else if (cmd.equalsIgnoreCase("MOD")) {
				Integer newQuantity =(Integer)m.getAttribute("Quantity");
				cart.modifyQty(productId, newQuantity);//改成新的數量
				return "showCart";
			}
			return "showCart";
		}
}
