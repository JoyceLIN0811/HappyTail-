package com.happytail.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytail.shopping.dao.ProductDao;
import com.happytail.shopping.model.ProductBeanImageData;

@Service
public class ShowProductService {
	@Autowired
	ProductDao dao;
	public List<ProductBeanImageData> Test(int categoryId){
		List<ProductBeanImageData> list = dao.getAllProductsImageDatasByCategory(categoryId);
		return list;
	}
}
