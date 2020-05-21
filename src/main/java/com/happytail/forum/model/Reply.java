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
@Table(name = "Reply")
public class Reply {
	
	private Integer id;
	private Integer userId;
	private String username;
	private Integer topicId;
	private String replyContent;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	public Reply(Integer userId, String username, Integer topicId
			, String replyContent, Timestamp createDate, Timestamp updateDate) {
		this.userId = userId;
		this.username = username;
		this.topicId = topicId;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	

	public Reply() {
		
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


	@Column(name = "replyContent")
	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
		return "Reply [id=" + id + ", userId=" + userId + ", username=" + username + ", topicId=" + topicId
				+ ", replyContent=" + replyContent + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
