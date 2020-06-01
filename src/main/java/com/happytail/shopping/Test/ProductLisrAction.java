package com.happytail.shopping.Test;

import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;
import com.happytail.shopping.controller.AddToFavorite;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.service.ProductLikeService;
import com.happytail.shopping.service.ProductService;
@Controller
public class ProductLisrAction {

		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		ProductLikeService ldao;
		@Autowired
		ProductService pdao;
		@Autowired
		PetMembersDAO mdao;
		
		@GetMapping(value = "/LikeTest")
		public ResponseEntity<ProductLike> addFacorite(
				 ){
				ProductBean pBean = pdao.selectOne(1);
				System.out.println("進入");
				ProductLike pLike=new ProductLike();
//				PetMembers member = (PetMembers)m.getAttribute("LoginOk");
			
				pLike.setBean(pBean);
				pLike.setPetMemberId(1);
				System.out.println("準備進入DAO");
				ldao.insert(pLike);
				System.out.println("成功匯入");
				ResponseEntity<ProductLike>   re=new ResponseEntity<ProductLike>(pLike, HttpStatus.OK);
				System.out.println(re);
return re ;
}
		
		
	}


