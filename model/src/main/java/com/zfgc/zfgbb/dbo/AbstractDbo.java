package com.zfgc.zfgbb.dbo;

import java.time.OffsetDateTime;

public abstract class AbstractDbo {

	public abstract Integer getPkId();

	public abstract OffsetDateTime getCreatedTime();

	public abstract OffsetDateTime getUpdatedTime();

	public OffsetDateTime getCreatedTs() {
		return null;
	}

	public void setCreatedTs(OffsetDateTime createdTs) {
		// no-op fallback; subclass overrides when a created_ts column exists
	}

	public OffsetDateTime getUpdatedTs() {
		return null;
	}

	public void setUpdatedTs(OffsetDateTime updatedTs) {
		// no-op fallback; subclass overrides when an updated_ts column exists
	}
}
