package com.bisn.basic;

import java.util.Scanner;

/*
 * 用数组实现约瑟夫出圈问题
 * 由m个人围成一个首尾相连的圈报数，从第1个人开始，从1开始，报到n的人剩下的人继续开始从1报数，直到所有的人都出圈为止。
 * 对于给定的m和n，求出所有人的出圈顺序
 */

public class Joseph {
	
	public static void main(String[] args) {
		//提示输入总人数
		System.out.print("请输入做这个游戏的人数：");
		Scanner sca = new Scanner(System.in);
		int m = sca.nextInt();
		
		//提示输入要出圈的数值
		System.out.print("请输入要出圈的数值：");
		int n = sca.nextInt();
		
		System.out.println("按出圈的次序输出序号：");
		
		int[] a = new int[m];//创建数组a，为int型，有m个元素
		int len = m;//圈中当前的人数即为数组的元素数
		
		//用循环方式给数组元素赋值
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		
		//用i作为元素下标，j代表当前要报的数
		int i = 0;
		int j = 1;
		
		while (len > 0) {
			if (a[i %m] > 0) {
				if (j % n == 0) {
					//找到要出圈的人，并把圈中的人数减1
					System.out.println(a[i % m] + " ");
					a[i % m] = -1;//将出圈后的相应位置上置-1
					j = 1;//重新报数，从1开始
					i++;
					len--;//圈中人数减1
				} else {
					//满足a[i % m] > 0，但不满足j % n == 0的情况
					//这个位置有人，但所报的数不是n的整数倍
					i++;
					j++;
				}
			} else {
				//不满足a[i % m] > 0的情况（遇到空位了
				//跳到下一个，但j不自加，即这个位置不报数
				i++;
			}
		}
	}

}
