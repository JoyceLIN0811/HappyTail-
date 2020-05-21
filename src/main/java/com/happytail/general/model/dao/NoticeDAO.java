package com.happytail.general.model.dao;

import com.happytail.general.model.Notice;

public interface NoticeDAO {
	
	public Notice insert(Notice notice);
	
	public boolean delete(Integer id);
	
	public Notice update(Notice notice);
	
	public Notice select(Integer id);
}