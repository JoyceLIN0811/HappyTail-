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
@Table(name = "Report")
public class Report {
	
	private Integer id;
	private Integer topicId;
	private Integer userId;
	private String username;
	private String isDone;
	private String message;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	public Report(Integer topicId, Integer userId, String username
	,String isDone, String message, Timestamp createDate, Timestamp updateDate) {
		this.topicId = topicId;
		this.userId = userId;
		this.username = username;
		this.isDone = isDone;
		this.message = message;
		this.createDate =createDate;
		this.updateDate = updateDate;
	}
	
	public Report() {
		
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

	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
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

	@Column(name = "isDone")
	public String getIsDone() {
		return isDone;
	}

	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return "Report [id=" + id + ", topicId=" + topicId + ", userId=" + userId + ", username=" + username
				+ ", isDone=" + isDone + ", message=" + message + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

	
}
