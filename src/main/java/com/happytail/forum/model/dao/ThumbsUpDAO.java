package com.happytail.forum.model.dao;

import com.happytail.forum.model.ThumbsUp;

public interface ThumbsUpDAO {
	
	public ThumbsUp insert(ThumbsUp thumbsUp);

	public boolean delete(Integer id);
	
	public ThumbsUp update(ThumbsUp thumbsUp);
	
	public ThumbsUp select(Integer id);
}
