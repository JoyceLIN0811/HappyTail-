package com.happytail.shopping.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "ProductLike")
public class ProductLike {
	@Id
	@Column(name="productLikeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productLikeId;
	@Column(name="productId")
	private Integer productId;
	@Column(name="petMemberId")
	private Integer petMemberId;
	@Column(name="updatetime")
	private java.sql.Timestamp updatetime;
	
	
	
	public ProductLike(int productLikeId, Integer productId, Integer petMemberId, Timestamp updatetime) {
		super();
		this.productLikeId = productLikeId;
		this.productId = productId;
		this.petMemberId = petMemberId;
		this.updatetime = updatetime;
	}
	public ProductLike() {
		
	}
	
	public int getLikeId() {
		return productLikeId;
	}
	public void setProductLikeId(int productLikeId) {
		this.productLikeId = productLikeId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPetMemberId() {
		return petMemberId;
	}
	public void setPetMemberId(Integer petMemberId) {
		this.petMemberId = petMemberId;
	}
	public java.sql.Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(java.sql.Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
}
