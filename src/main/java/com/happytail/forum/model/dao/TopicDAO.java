package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.Hit;
import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.TopiclistView;

public interface TopicDAO {
	
	public Topic insert(Topic topic);
	
	public boolean delete(Integer id);
	
	public Topic update(Topic topic);
	
	public Topic select(Integer id);
}
