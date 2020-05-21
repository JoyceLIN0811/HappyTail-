package com.happytail.forum.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ReplylistView")
public class ReplylistView {
	
	private Integer replyId;
	private Integer memberId;
	private String username;
	private Integer topicId;
	private String title;
	private String replyContent;
	private Timestamp createDate;
	private Integer likeNum;
	
	public ReplylistView(Integer replyId, Integer memberId, String username
	, Integer topicId, String title, String replyContent, Timestamp createDate
	, Integer likeNum) {
		this.replyId = replyId;
		this.memberId = memberId;
		this.username = username;
		this.topicId = topicId;
		this.title = title;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.likeNum = likeNum;
	}
	
	public ReplylistView() {
		
	}

	@Id
	@Column(name = "replyId")
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
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

	@Column(name = "likeNum")
	public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	@Override
	public String toString() {
		return "ReplylistView [replyId=" + replyId + ", memberId=" + memberId + ", username=" + username + ", topicId="
				+ topicId + ", title=" + title + ", replyContent=" + replyContent + ", createDate=" + createDate
				+ ", likeNum=" + likeNum + "]";
	}
	
	
}
