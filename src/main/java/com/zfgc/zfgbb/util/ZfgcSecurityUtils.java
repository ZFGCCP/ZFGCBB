package com.zfgc.zfgbb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ZfgcSecurityUtils{
	public static String generateMd5(String digestStr){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(digestStr.getBytes());
			byte[] hash = digest.digest();
			
			return Base64.getUrlEncoder().encodeToString(hash);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}