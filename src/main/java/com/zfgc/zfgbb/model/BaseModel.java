package com.zfgc.zfgbb.model;

import java.time.Instant;

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseModel {
	@JsonIgnore
	private Instant updatedTs;
	@JsonIgnore
	private Instant createdTs;
	
	public abstract Integer getId();
	public abstract void setId(Integer id);
	
	public Instant getUpdatedTs() {
		return updatedTs;
	}
	
	public Instant getCreatedTs() {
		return updatedTs;
	}
	
	public void setUpdatedTs(Instant updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	public void setCreatedTs(Instant createdTs) {
		this.createdTs = createdTs;
	}
	
}