package com.happytail.shopping.dao;

import java.util.List;

import org.hibernate.Session;

import com.happytail.shopping.model.ProductLike;

public interface ProductLikeDao {

	Session s();

	String insert(ProductLike pLike);

	Boolean delete(ProductLike pLike);

	List<ProductLike> showLikes(Integer memberId);

}