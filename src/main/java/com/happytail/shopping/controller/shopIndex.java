package com.happytail.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class shopIndex {

	
	@GetMapping("/shopIndex")
	public String go1() {
		System.out.println("進入");
		return "shopIndex";
	}
	
	
}
