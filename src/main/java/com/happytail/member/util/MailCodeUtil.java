package com.happytail.member.util;

import java.util.UUID;

public class MailCodeUtil {
	
	public static String startCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String forgetPwdCode() {
		String m = String.valueOf(Math.floor((Math.random()*100000)));
		System.out.println(m);
		return m;
	}
	
}
