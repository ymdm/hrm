package com.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Integer id; //用户id
	private String username; //用户名
	private String loginname;//登录名
	private String password;//密码
	private Integer status;//用户状态
	private Date createDate;//创建日期
	public User() {
		super();
	}
	public User(Integer id, String username, String loginname, String password, Integer status, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.createDate = createDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginname=" + loginname + ", password=" + password
				+ ", status=" + status + ", createdate=" + createDate + "]";
	}
	
}
