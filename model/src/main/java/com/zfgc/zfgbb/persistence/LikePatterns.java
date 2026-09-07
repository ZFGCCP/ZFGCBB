package com.zfgc.zfgbb.persistence;

public final class LikePatterns {

	private LikePatterns() {
	}

	public static String contains(String value) {
		if (value == null)
			throw new IllegalArgumentException("contains pattern requires a value");
		return "%" + value.replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_") + "%";
	}
}
