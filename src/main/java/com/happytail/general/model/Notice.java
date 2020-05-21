package com.happytail.general.model;

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
@Table(name = "Notice")
public class Notice {
	
	private Integer id;
	private String module;
	private Integer userId;
	private String username;
	private String message;
	private String link;
	private String isRead;
	private Timestamp createDate;
	private Timestamp updateDate;

	
	public Notice(String module,Integer userId,String username,
			String message,String link,String isRead,Timestamp createDate,
			Timestamp updateDate) {
		this.module = module;
		this.userId = userId;
		this.username = username;
		this.message = message;
		this.link = link;
		this.isRead = isRead;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public Notice() {
		
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

	@Column(name = "module")
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "link")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "isRead")
	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
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
		return "Notice [id=" + id + ", module=" + module + ", userId=" + userId + ", username=" + username
				+ ", message=" + message + ", link=" + link + ", isRead=" + isRead + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
}
