package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.ReportlistView;

public interface ReportlistViewDAO {
	
	public List<ReportlistView> select();
	
	public Long Counts();

}
