package com.happytail.forum.model.dao;

import com.happytail.forum.model.History;

public interface HistoryDAO {

	public History saveTopic(History history);

	public boolean delete(Integer id);

	public History select(Integer id);

}
