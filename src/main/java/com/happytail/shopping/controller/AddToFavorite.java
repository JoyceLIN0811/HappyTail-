package com.happytail.shopping.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.service.ProductLikeService;
import com.happytail.shopping.service.ProductService;

@Controller
public class AddToFavorite {
	@Autowired
	SessionFactory  sessionFactory;
	@Autowired
	ProductLikeService dao;
	@Autowired
	ProductService pdao;
	@Autowired
	ProductLikeService ldao;
	
	
	@GetMapping(value = "/addToLike")
	public ResponseEntity<ProductLike> addFacorite(
			@RequestParam("productId")Integer productId,
			Model m
			 ){
			ProductBean pBean = pdao.selectOne(productId);
			System.out.println("進入");
			ProductLike pLike=new ProductLike();
//			PetMembers member = (PetMembers)m.getAttribute("LoginOk");
			pLike.setBean(pBean);
			pLike.setPetMemberId(1);
//			pLike.setProductId(productId);
//			 SimpleDateFormat    date = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
			 Timestamp date2= new Timestamp(System.currentTimeMillis());
			 
//			 String format = date.format(date2);
//			 System.out.println(date);
			 pLike.setUpdatetime(date2);
			System.out.println("準備進入DAO");
			ldao.insert(pLike);
			System.out.println("成功匯入");
			ResponseEntity<ProductLike>   re=new ResponseEntity<ProductLike>(pLike, HttpStatus.OK);
			System.out.println(re);
return re ;
}
}
