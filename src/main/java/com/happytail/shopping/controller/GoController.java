package com.happytail.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.service.ProductService;
import com.happytail.shopping.model.service.ShowProductService;



@Controller
public class GoController {

	@Autowired
	SessionFactory session;
	@Autowired
	 ProductService dao ;
	@Autowired
	ShowProductService ShowProductService;
	
	@GetMapping("/showProduct")
	public String go() {
		return "showProduct";
	}
	@GetMapping("/shopIndex")
	public String go1() {
		System.out.println("進入商城首頁");
		return "shopIndex";
	}
	
	@GetMapping("/intoCart")
	public String intoCart() {
		
		return"shoppingCart";
	}
	
	@PostMapping(value = "/showProduct.do")
	public String showProductByCategory(Model m,HttpServletRequest request,@RequestParam("categoryId") Integer categoryId ) {

		System.out.println("傳入資料狀況:"+categoryId);	
		List<ProductBean> list = dao.selectCategory(categoryId);
		m.addAttribute("productList", list);
		System.out.println("抓取資料成功");

		return "showProduct";
	}
	
	@GetMapping(value = "/showProduct2")
	public String showProduct2(Model m,HttpServletRequest request ) {

//		System.out.println("傳入資料狀況:"+categoryId);	
		List<ProductBean> list = dao.selectCategory(1);
		m.addAttribute("productList", list);
		System.out.println("抓取資料成功");

		return "showProduct";
	}
	
	
	
}
