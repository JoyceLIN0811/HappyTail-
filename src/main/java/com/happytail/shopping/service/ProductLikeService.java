package com.happytail.shopping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.happytail.shopping.dao.ProductLikeDao;
import com.happytail.shopping.model.ProductLike;
@Transactional
@Service
public class ProductLikeService {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductLikeDao dao;
	
	public  String insert(ProductLike pLike) {
		return dao.insert(pLike);
	}
	
	public Boolean delete(ProductLike pLike) {
		return dao.delete(pLike);
	}
	
	public List<ProductLike> showLikes(Integer memberId){
		return showLikes(memberId);
	}
}
