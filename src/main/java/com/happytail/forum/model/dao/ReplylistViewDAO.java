package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.ReplylistView;


public interface ReplylistViewDAO {
	
	public List<ReplylistView> select(int topicId);

	public long AllReplyCounts(int topicId);

}
