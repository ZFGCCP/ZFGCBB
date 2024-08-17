package com.zfgc.zfgbb.dbo;

import java.time.LocalDateTime;

public abstract class AbstractDbo {
	
	public abstract Integer getPkId();
	public abstract LocalDateTime getUpdatedTime();
	
}