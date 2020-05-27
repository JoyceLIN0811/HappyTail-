package com.happytail.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestIndex {

	@GetMapping("/showProduct")
	public String go() {
		return "showProduct";
	}
	@GetMapping("/shopIndex")
	public String go1() {
		return "shopIndex";
	}
	
	
}
