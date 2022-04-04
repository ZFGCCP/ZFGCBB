package com.zfgc.zfgbb.dbo;

import java.time.LocalDate;

public abstract class AbstractDbo {
	
	public abstract Integer getPkId();
	public abstract LocalDate getUpdatedTime();
	
}