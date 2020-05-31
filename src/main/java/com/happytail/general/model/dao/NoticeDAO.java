package com.happytail.general.model.dao;

import java.util.List;

import com.happytail.general.model.Notice;

public interface NoticeDAO {
	
	public Notice insert(Notice notice);
	
	public boolean delete(Integer id);
	
	public Notice update(Notice notice);
	
	public Notice select(Integer id);
	
	public List<Notice> selectAll();
	
	public List<Notice> selectByModule(String module);
	
	public Notice selectByUserId(Integer UserId);

	}