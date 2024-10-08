package com.zfgc.zfgbb.model.core;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class ContentResource extends BaseModel {
	
	@JsonIgnore
	private Integer contentResourceId;
    private Integer contentTypeId;
    private Integer uploadedUserId;
    private String filename;
    private String checksum;
    private String fileExt;
    private String mimeType;
	@Override
	public Integer getId() {
		return contentResourceId;
	}
	@Override
	public void setId(Integer id) {
		contentResourceId = id;
	}
	
	public Integer getContentResourceId() {
		return contentResourceId;
	}
	public void setContentResourceId(Integer contentResourceId) {
		this.contentResourceId = contentResourceId;
	}
	public Integer getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public Integer getUploadedUserId() {
		return uploadedUserId;
	}
	public void setUploadedUserId(Integer uploadedUserId) {
		this.uploadedUserId = uploadedUserId;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
