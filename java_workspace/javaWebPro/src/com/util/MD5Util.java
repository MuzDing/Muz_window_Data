package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MD5Util {
	public static String getMD5(String str){
		try {
			str = str + "javaweb";
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1,md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@Test
	public void TestMd5(){
		String pwd = "000000";
		System.out.println(getMD5(pwd));
	}
}
