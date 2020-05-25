package com.happytail.forum.model.dao;

import com.happytail.forum.model.Follow;

public interface FollowDAO {
	
	public Follow insert(Follow follow);

	public boolean delete(Integer id);
	
	//update改變status或更新文章
	public Follow update(Follow follow);
	
	public Follow select(Integer id);

}
