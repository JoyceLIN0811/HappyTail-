package com.happytail.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.admin.model.AdminShopDao;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.ProductBean;

@Service
@Transactional
public class AdminShopServiceImpl implements AdminShopService{

	@Autowired
	AdminShopDao adsDao;
	
	@Override
	public Long countProjects() {
		Long count = adsDao.countProjects();
		return count;
	}

	@Override
	public Long countOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double sumOrders() {
		Double sum = adsDao.sumOrders();
		return sum;
	}

	@Override
	public Long countProjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long unCheckOrders() {
		Long count = adsDao.unCheckOrders();
		return count;
	}

	@Override
	public List<Long> sumOrdersByMonth() {
		List<Long> list = adsDao.sumOrdersByMonth();
		return list;
	}

	@Override
	public List<OrderBean> adminAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBean> unCheckOrderList() {
		List<OrderBean> list = adsDao.unCheckOrderList();
		return list;
	}

	@Override
	public ProductBean updateProduct(Integer id) {
		ProductBean product = adsDao.updateProduct(id);
		return product;
	}

}
