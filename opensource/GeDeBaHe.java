package com.bisn.opensource;

import java.util.Scanner;

/*
 * 哥德巴赫猜想：任一大于2的偶数都可写成两个素数之和
 */

public class GeDeBaHe {
	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		System.out.println("请您输入一个大于2的偶数：");
		int x = rd.nextInt();
		Prime c = new Prime();
		
		for (int i = 2; i <= x / 2; i++) {
			if (c.b(i) && c.b(x - i)) {
				System.out.println(x + "=" + i + "+" + (x - i));
			}
		}
	}
}

/*
 * 判断一个整数是否为素数的类
 */
class Prime {
	//判断素数
	boolean b(int i) {
		for (int j = 2; j <= i / 2; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		
		return true;
	}
}
