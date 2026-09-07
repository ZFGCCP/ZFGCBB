package com.zfgc.zfgbb.model.users;

public record EncodedPassword(PasswordAlgo algo, String salt, String hash) {

	private static final String DELIMITER = ":";

	public String toEncoded() {
		return algo.name() + DELIMITER + (salt == null ? "" : salt) + DELIMITER + hash;
	}

	public static EncodedPassword parse(String encoded) {
		if (encoded == null)
			throw new IllegalArgumentException("Encoded password is null.");
		String[] parts = encoded.split(DELIMITER, 3);
		if (parts.length < 3)
			throw new IllegalArgumentException("Encoded password is malformed.");
		PasswordAlgo algo = parts[0].isEmpty() ? PasswordAlgo.BCRYPT : PasswordAlgo.valueOf(parts[0]);
		String salt = parts[1].isEmpty() ? null : parts[1];
		String hash = parts[2];
		return new EncodedPassword(algo, salt, hash);
	}
}
