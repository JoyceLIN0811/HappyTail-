package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.TopiclistView;

public interface TopliclistViewDAO {

	public List<TopiclistView> select();

	public List<TopiclistView> selectByCategoryId(Integer categoryId);

	public List<TopiclistView> selectByMemberId(Integer memberId);
	
	public long AllTopicCounts();
	
	public long CategoryTopicCounts(Integer categoryId);

	public long MyTopicCounts(Integer memberId);
	
	
}
