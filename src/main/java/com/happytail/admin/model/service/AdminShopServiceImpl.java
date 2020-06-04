package com.happytail.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.admin.model.AdminShopDao;

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
	public Long sumOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countProjectType() {
		// TODO Auto-generated method stub
		return null;
	}

}
