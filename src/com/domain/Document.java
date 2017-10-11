package com.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Document implements Serializable{
	private Integer id;
	private String title;
	private String fileName;
	private String remark;
	private Date createdate;
	private MultipartFile file;
	private User user;
	public Document() {
		super();
	}
	public Document(Integer id, String title, String filename, String remark, Date createdate, MultipartFile file,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.fileName = filename;
		this.remark = remark;
		this.createdate = createdate;
		this.file = file;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String filename) {
		this.fileName = filename;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", filename=" + fileName + ", remark=" + remark
				+ ", createdate=" + createdate + ", file=" + file + ", user=" + user + "]";
	}
	
}








