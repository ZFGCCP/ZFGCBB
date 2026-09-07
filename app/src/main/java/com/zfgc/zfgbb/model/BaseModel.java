package com.zfgc.zfgbb.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {
	private OffsetDateTime updatedTs;
	private OffsetDateTime createdTs;

	public abstract Integer getId();
	public abstract void setId(Integer id);
}