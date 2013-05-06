package com.bisn.basic;

import java.util.Scanner;

/*
 * 获取用户输入
 */

public class ScannerTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);//定义输入变量
		System.out.print("请输入任意数值或字符串：");//提示输入任意数值或字符串
		String g = in.next();
		System.out.println("您输入的是：" + g);
	}
}
