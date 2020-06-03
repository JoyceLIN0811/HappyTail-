package com.happytail.admin.model.service;

public interface AdminMembersService {

	// 所有會員總數
	public Long countMembers();

	// 所有男性會員總數
	public Long countMale();

	// 所有女性會員總數
	public Long countFemale();

	// 更改會員狀態
	public Integer changeMemberStatus(Integer id);

}
