package com.zfgc.zfgbb.util;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

public class ZfgcStringUtils extends StringUtils{
	
	public static char[] getUnderlyingStringArray(String input) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		return input.toCharArray();
	}
}