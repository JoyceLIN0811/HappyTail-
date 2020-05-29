package com.happytail.shopping.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	
	public ResponseEntity<ProductLike> addFacorite(Model m, 
											@RequestParam("productId")Integer productId ){
		ProductBean pBean = pdao.selectOne(productId);
		ProductLike pLike= (ProductLike) m.getAttribute("productLike");
		PetMembers member = (PetMembers)m.getAttribute("LoginOk");
		pLike.setBean(pBean);
		pLike.setPetMemberId(member.getId());
		
		dao.insert(pLike);
		System.out.println("成功匯入");
		ResponseEntity<ProductLike>   re=new ResponseEntity<ProductLike>(pLike, HttpStatus.OK);
		
		return re ;
	}
}
