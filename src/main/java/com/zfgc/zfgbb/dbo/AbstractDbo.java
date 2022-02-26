package com.zfgc.zfgbb.dbo;

import java.time.Instant;

public abstract class AbstractDbo {
	
	public abstract Integer getRecordId();
	public abstract Instant getUpdatedTime();
	
}