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
@Table(name = "Topic")
public class Topic {
	
	private Integer id;
	private Integer categoryId;
	private String title;
	private String content;
	private Integer userId;
	private String username;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	public Topic(Integer categoryId, String title, String content, Integer userId,
	String username, Timestamp createDate,Timestamp updateDate) {
		this.categoryId = categoryId;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.username = username;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public Topic() {
		
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

	@Column(name = "categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Topic [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", content=" + content
				+ ", userId=" + userId + ", username=" + username + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
	
}
