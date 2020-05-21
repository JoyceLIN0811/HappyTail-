package com.happytail.forum.model.dao;

import com.happytail.forum.model.Favorate;

public interface FavorateDAO{
	
	public Favorate insert(Favorate favorate);

	//修改的方式 - 全刪再重存
	public boolean delete(Integer id);
		
	public Favorate selectByUserId(Integer id);

}
