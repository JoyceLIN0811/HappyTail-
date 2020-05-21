package com.happytail.forum.model.dao;

import com.happytail.forum.model.LimitPost;

public interface LimitPostDAO {
	
	public LimitPost saveTopic(LimitPost limitPost);

	public boolean delete(Integer id);

	public LimitPost select(Integer id);

}
