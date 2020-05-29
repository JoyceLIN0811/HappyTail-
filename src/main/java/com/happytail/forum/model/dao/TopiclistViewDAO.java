package com.happytail.forum.model.dao;

import java.util.List;
import java.util.Map;

import com.happytail.forum.model.TopiclistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

public interface TopiclistViewDAO {

	public Page<TopiclistView> getAllTopiclist(PageInfo pageInfo);

	public Page<TopiclistView> getCategoryTopiclist(PageInfo pageInfo, Integer categoryId);

	public Page<TopiclistView> getMemberIdTopiclist(PageInfo pageInfo, Integer memberId);

	public Page<TopiclistView> getHitAllTopiclist(PageInfo pageInfo);
	
	public Page<TopiclistView> getHitCategoryTopiclist(PageInfo pageInfo, Integer categoryId);
	
	public Long allTopicCounts();

	public Long categoryTopicCounts(Integer categoryId);

	public Long myTopicCounts(Integer memberId);

//	public List<TopiclistView> select();

//	public List<TopiclistView> selectByCategoryId();

//	public List<TopiclistView> selectByMemberId(Integer memberId);
	
//	public PageInfo getPageInfo(Map<String, Object> paramMap);

}
