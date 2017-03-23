package org.framework.web.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	/**
	 * MD5加密
	 * @param str
	 * @return
	 */
	public static String encode(String str){
		return DigestUtils.md5Hex(str);
	}
	
	public static void main(String[] args) {
		System.out.println(encode("123456"));
	}
}
