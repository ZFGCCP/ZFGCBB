package com.zfgc.zfgbb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.time.DateUtils;

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
	
}