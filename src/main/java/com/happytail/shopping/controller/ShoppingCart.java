package com.happytail.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCart {

	@GetMapping("/intoCart")
	public String intoCart() {
		
		return"shoppingCart";
	}
}
