package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.TopiclistView;

public interface TopiclistViewDAO {

	public List<TopiclistView> select();

	public List<TopiclistView> selectByCategoryId(Integer categoryId);

	public List<TopiclistView> selectByMemberId(Integer memberId);
	
	public Long AllTopicCounts();
	
	public Long CategoryTopicCounts(Integer categoryId);

	public Long MyTopicCounts(Integer memberId);
	
	
}
