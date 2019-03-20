package com.ibm.pixogram.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "media_items")
public class MediaItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String username;
	
	@Column
	private String filename;
	
	@Column
	private String type; //video|image
	
	@Column
	private String location;
	
	@Column(name = "filetype")
	private String fileType;
	
	@Column
	private long size;
	
	@Column
	private boolean hidden;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "upload_date")
	private Date uploadDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "upload_time")
	private Date uploadTime;
	
	public MediaItem() {
		
	}
	
	public MediaItem(long id, String username, String filename, String type, String location,
			String fileType, long size, boolean hidden, Date uploadDate, Date uploadTime) {
		
		this.id = id;
		this.username = username;
		this.filename = filename;
		this.type = type;
		this.location = location;
		this.fileType = fileType;
		this.size = size;
		this.hidden = hidden;
		this.uploadDate = uploadDate;
		this.uploadTime = uploadTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}
