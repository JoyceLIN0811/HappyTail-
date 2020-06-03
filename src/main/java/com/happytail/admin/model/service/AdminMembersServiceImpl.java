package com.happytail.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.admin.model.AdminMembersDao;

@Service
@Transactional
public class AdminMembersServiceImpl implements AdminMembersService {

	@Autowired
	AdminMembersDao adDao;
	
	@Override
	public Long countMembers() {
		Long count = adDao.countMembers();
		return count;
	}
	
	@Override
	public Long countMale() {
		Long count = adDao.countMale();
		return count;
	}
	
	@Override
	public Long countFemale() {
		Long count = adDao.countFemale();
		return count;
	}

	@Override
	public Integer changeMemberStatus(Integer id) {
		
		return null;
	}

}
