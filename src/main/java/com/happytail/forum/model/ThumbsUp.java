package com.happytail.forum.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ThumbsUp {
	
	private Integer id;
	private String type;
	private Integer topicId;
	private Integer replyId;
	private Integer userId;
	private String username;
	private Integer likeTypeId;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	
	public ThumbsUp(String type, Integer topicId, Integer replyId
	,Integer userId, String username, Integer likeTypeId, Timestamp createDate
	, Timestamp updateDate) {
		this.type = type;
		this.topicId = topicId;
		this.replyId = replyId;
		this.userId = userId;
		this.username = username;
		this.likeTypeId = likeTypeId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		}

	public ThumbsUp() {
		
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

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "replyId")
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
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

	@Column(name = "likeTypeId")
	public Integer getLikeTypeId() {
		return likeTypeId;
	}

	public void setLikeTypeId(Integer likeTypeId) {
		this.likeTypeId = likeTypeId;
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
		return "ThumbsUp [id=" + id + ", type=" + type + ", topicId=" + topicId + ", replyId=" + replyId + ", userId="
				+ userId + ", username=" + username + ", likeTypeId=" + likeTypeId + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
}
