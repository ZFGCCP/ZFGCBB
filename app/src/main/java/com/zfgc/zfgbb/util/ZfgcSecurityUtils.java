package com.zfgc.zfgbb.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class ZfgcSecurityUtils {

	public static String sha256Hex(String input) {
		try {
			return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256")
					.digest(input.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException unavailable) {
			throw new IllegalStateException("SHA-256 not available", unavailable);
		}
	}
}
