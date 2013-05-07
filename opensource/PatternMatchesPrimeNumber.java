package com.bisn.opensource;

/*
 * 利用正则表达式判断质数（素数）
 * ^1?$是用来排除1，因为1也不匹配^(11+?)\1+$
 * ^(11+?)\1+$很有意思，如果匹配这个正则表达式，如果后面的\1+重复了1次，那么能被2整除，重复了n-1次,就能被n整除，固然不是素数了
 */

public class PatternMatchesPrimeNumber {

	public static void main(String[] args) {
		String regex = "^1?$|^(11+?)\\1+$";// 正则表达式
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < 1000; i++) {
			sb.append("1");
			if (!sb.toString().matches(regex)) {
				System.out.println(i);
			}
		}
	}

}
