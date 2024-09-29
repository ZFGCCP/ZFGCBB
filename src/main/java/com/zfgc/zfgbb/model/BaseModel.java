package com.zfgc.zfgbb.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseModel {
	@JsonIgnore
	private LocalDateTime updatedTs;
	@JsonIgnore
	private LocalDateTime createdTs;
	
	public abstract Integer getId();
	public abstract void setId(Integer id);
	
	public LocalDateTime getUpdatedTs() {
		return updatedTs;
	}
	
	public LocalDateTime getCreatedTs() {
		return updatedTs;
	}
	
	public void setUpdatedTs(LocalDateTime updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	public void setCreatedTs(LocalDateTime createdTs) {
		this.createdTs = createdTs;
	}
	
	public String getCreatedTsAsString() {
		if(createdTs != null) {
			return createdTs.format(DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm:SS"));
		}
		return "";
	}
	
}