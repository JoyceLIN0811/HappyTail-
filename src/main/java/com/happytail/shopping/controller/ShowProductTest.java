package com.happytail.shopping.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductBeanImageData;
import com.happytail.shopping.service.ProductService;
import com.happytail.shopping.service.ShowProductService;

@Controller
public class  ShowProductTest{
	@Autowired
	SessionFactory session;
	@Autowired
	 ProductService dao ;
	@Autowired
	ShowProductService ShowProductService;
	
//	@Autowired
//	 ProductDao dao ;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/allProductNoImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBean>> allProductNoImage() {
//	public String test() {
		System.out.println("進入controller");
		System.out.println("test");
		List<ProductBean> selectAll = dao.selectAll();
		ResponseEntity<List<ProductBean>> re  = new ResponseEntity<>(selectAll, HttpStatus.OK);
//		System.out.println(re);
		
		return re;
	}
	
	@GetMapping(value = "/allProductWithImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBeanImageData>> allProductWithImage() {
//	public String test() {
		System.out.println("進入controller");
		System.out.println("test");
		List<ProductBeanImageData> list = dao.getAllProductsImageDatas();
		ResponseEntity<List<ProductBeanImageData>> re  = new ResponseEntity<>(list, HttpStatus.OK);
//		System.out.println(re);
		
		return re;
	}
	
//	@GetMapping(value = "/OutputLineChart", produces= {"application/json"} )
//	public ResponseEntity<List<LChartBean>> OutputLineChart(@RequestParam String yearmonths, Model model) {
//		List<LChartBean> list = commentServiceIMPL.getLineChart(yearmonths);
//		ResponseEntity<List<LChartBean>> re  = new ResponseEntity<>(list, HttpStatus.OK);
//		return re;
//	}

		@PostMapping("/showProductByCategory")
		public String showProductByCategory(Model m,HttpServletRequest request,@RequestParam("categoryId") Integer categoryId ) {
//			System.out.println("進categoryId_#showProductByCategory");
//			System.out.println("傳入資料狀況:"+categoryId);	
			List<ProductBean> list = dao.selectCategory(categoryId);
			m.addAttribute("productList", list);
//			System.out.println("categoryId="+categoryId);
//			System.out.println("list"+list);
//			System.out.println("list"+list.get(0).getBiPhoto());
			return "showProduct";
		}
	
	
	
	
}
