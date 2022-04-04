package com.zfgc.zfgbb.model;

import java.time.Instant;
import java.time.LocalDate;

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseModel {
	@JsonIgnore
	private LocalDate updatedTs;
	@JsonIgnore
	private LocalDate createdTs;
	
	public abstract Integer getId();
	public abstract void setId(Integer id);
	
	public LocalDate getUpdatedTs() {
		return updatedTs;
	}
	
	public LocalDate getCreatedTs() {
		return updatedTs;
	}
	
	public void setUpdatedTs(LocalDate updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	public void setCreatedTs(LocalDate createdTs) {
		this.createdTs = createdTs;
	}
	
}