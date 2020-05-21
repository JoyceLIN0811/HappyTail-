package com.happytail.forum.model;

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
@Table(name = "Follow")
public class Follow {
	
	private Integer id;
	private Integer userId;
	private String username;
	private Integer topicId;
	private String status;
	private Timestamp createDate;
	private Timestamp updateDate;

	public Follow(Integer userId, String username, Integer topicId
	,String status, Timestamp createDate, Timestamp updateDate) {
		this.userId = userId;
		this.username = username;
		this.topicId = topicId;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public Follow() {
		
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userId")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "createDate")
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "updateDate")
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Follow [id=" + id + ", userId=" + userId + ", username=" + username + ", topicId=" + topicId
				+ ", status=" + status + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}

