package com.qhit.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encrypt {

/**
	 * 加密
	 * 
	 * @param inputText
	 * @return
	 */
	public static String e(String inputText) {
		String result=DigestUtils.md5Hex(inputText);
		return result;
	}
 
	/**
	 * 二次加密，应该破解不了了吧？
	 * 
	 * @param inputText
	 * @return
	 */
	/*public static String md5AndSha(String inputText) {
		return sha(md5(inputText));
	}*/
 
	/**
	 * md5加密
	 * 
	 * @param inputText
	 * @return
	 */
/*	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}*/
 
	/**
	 * sha加密
	 * 
	 * @param inputText
	 * @return
	 */
	/*public static String sha(String inputText) {
		return encrypt(inputText, "sha-1");
	}
 */
	/**
	 * md5或者sha-1加密
	 * 
	 * @param inputText
	 *            要加密的内容
	 * @param algorithmName
	 *            加密算法名称：md5或者sha-1，不区分大小写
	 * @return
	 */
	/*private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}
 
	*//**
	 * 返回十六进制字符串
	 * 
	 * @param arr
	 * @return
	 *//*
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String iString="e10adc3949ba59abbe56e057f20f883e";
		System.out.println(md5("123456"));
	}*/
}