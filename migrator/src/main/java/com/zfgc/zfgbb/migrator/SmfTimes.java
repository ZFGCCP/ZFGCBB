package com.zfgc.zfgbb.migrator;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class SmfTimes {

	public static OffsetDateTime fromEpochSeconds(Integer seconds) {
		if (seconds == null || seconds <= 0) {
			return null;
		}
		return OffsetDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneOffset.UTC);
	}

	private SmfTimes() {}
}
