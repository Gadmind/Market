package com.qhit.util;

import java.util.UUID;

public class RandomNumber {
	public static String[] chineseDigits = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "").toUpperCase();
	}

	public static String digitsTochinese(int i) {
		// 大于10的需要重写
		return chineseDigits[i];
	}

	public static String toAllUpperCase(String uuid) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < uuid.length(); i++) {
			char c = uuid.charAt(i);
			if (Character.isLowerCase(c)) {
				buffer.append(Character.toUpperCase(c));
			} else {
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(randomUUID());
	}
}
