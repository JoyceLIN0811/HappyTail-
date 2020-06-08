package com.happytail.admin.model.service;

import java.util.List;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.ProductBean;

public interface AdminShopService {
	
	//商品總數
	public Long countProjects();
	//訂單總數
	public Long countOrders();
	//商品銷售金額
	public Double sumOrders();
	//商品類別數
	public Long countProjectType();
	//未處理訂單數
	public Long unCheckOrders();
	//每月銷售額
	public List<Long> sumOrdersByMonth();
	
	//所有訂單
	public List<OrderBean> adminAllOrders();
	//未處理訂單
	public List<OrderBean> unCheckOrderList();
	
	//修改產品
	ProductBean updateProduct(Integer id);

}
