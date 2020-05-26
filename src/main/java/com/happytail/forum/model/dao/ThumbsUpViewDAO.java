package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.ThumbsUpView;


public interface ThumbsUpViewDAO {
	
	public List<ThumbsUpView> selectByTopicId(Integer topicId);

	public List<ThumbsUpView> selectByReplyId(Integer replyId);

	public List<ThumbsUpView> selectByMemberId(Integer memberId);
	
	public Long TopicAllCounts(Integer topicId);
	
	public Long TopicCategoryCounts(Integer categoryId);
	
	public Long ReplyAllCounts(Integer replyId);


}
