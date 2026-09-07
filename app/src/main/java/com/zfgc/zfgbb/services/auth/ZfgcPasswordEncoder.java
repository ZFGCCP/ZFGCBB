package com.zfgc.zfgbb.services.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.model.users.EncodedPassword;
import com.zfgc.zfgbb.model.users.PasswordAlgo;


@Component
public class ZfgcPasswordEncoder implements PasswordEncoder {

	private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@Override
	public String encode(CharSequence rawPassword) {
		return hash(rawPassword.toString()).toEncoded();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (rawPassword == null || encodedPassword == null)
			return false;
		EncodedPassword parsed;
		try {
			parsed = EncodedPassword.parse(encodedPassword);
		} catch (IllegalArgumentException invalidEncoding) {
			return false;
		}
		return verify(rawPassword.toString(), parsed.hash(), parsed.algo(), parsed.salt());
	}

	@Override
	public boolean upgradeEncoding(String encodedPassword) {
		if (encodedPassword == null)
			return false;
		try {
			return EncodedPassword.parse(encodedPassword).algo() == PasswordAlgo.SMF2_SHA1;
		} catch (IllegalArgumentException invalidEncoding) {
			return false;
		}
	}

	public EncodedPassword hash(String raw) {
		return new EncodedPassword(PasswordAlgo.BCRYPT, null, bcrypt.encode(raw));
	}

	public boolean verify(String raw, String storedHash, PasswordAlgo algo, String salt) {
		if (raw == null || storedHash == null || algo == null)
			return false;
		return switch (algo) {
			case BCRYPT -> bcrypt.matches(raw, storedHash);
			case SMF2_SHA1 -> verifySmf2Sha1(raw, storedHash, salt);
		};
	}

	private boolean verifySmf2Sha1(String raw, String storedHash, String salt) {
		if (salt == null)
			return false;
		return MessageDigest.isEqual(sha1Hex(salt + raw).getBytes(StandardCharsets.UTF_8),
				storedHash.getBytes(StandardCharsets.UTF_8));
	}

	private static String sha1Hex(String input) {
		try {
			return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-1")
					.digest(input.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException unavailable) {
			throw new IllegalStateException("SHA-1 not available", unavailable);
		}
	}
}
