package com.happytail.shopping.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class shopIndex {
	@Autowired
	SessionFactory SessionFactory;
	
	@GetMapping("/ToShopIndex")
	public String go1() {
		System.out.println("進入");
		return "shopIndex";
	}
	
	
}
