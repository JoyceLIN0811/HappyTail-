package com.happytail.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ThumbsUpView")
public class ThumbsUpView {
	
	private Integer id;
	private Integer memberId;
	private String username;
	private Integer topicId;
	private String title;
	private Integer replyId;
	private String replyContent;
	private String type;
	private Integer categoryId;
	private String category;
	
	public ThumbsUpView(Integer memberId, String username, Integer topicId
	,String title, Integer replyId, String replyContent, String type
	,Integer categoryId, String category) {
		this.memberId  = memberId;
		this.username = username;
		this.topicId = topicId;
		this.title = title;
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.type = type;
		this.categoryId = categoryId;
		this.category = category;
	}
	
	public ThumbsUpView() {
		
	}
	
	@Id
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "memberId")
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "replyId")
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	@Column(name = "replyContent")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ThumbsUpView [id=" + id + ", memberId=" + memberId + ", username=" + username + ", topicId=" + topicId
				+ ", title=" + title + ", replyId=" + replyId + ", replyContent=" + replyContent + ", type=" + type
				+ ", categoryId=" + categoryId + ", category=" + category + "]";
	}
	
	
}
