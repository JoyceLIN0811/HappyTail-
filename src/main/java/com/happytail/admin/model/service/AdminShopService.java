package com.happytail.admin.model.service;

public interface AdminShopService {
	
	//商品總數
	public Long countProjects();
	//訂單總數
	public Long countOrders();
	//商品銷售金額
	public Long sumOrders();
	//商品類別數
	public Long countProjectType();

}
