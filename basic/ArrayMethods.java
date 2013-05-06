package com.bisn.basic;

import java.util.Arrays;

/*
 * 测试数组的方法
 * copyOfRange：将指定数组的指定范围复制到一个新数组
 * copyOf：复制指定的数组，截取或用0填充（如有必要），使副本具有指定长度
 * sort：对指定int型数组的指定范围按数字升序排序
 * binarySearch：使用二分搜索法来搜索指定的int型数组，以获得指定的值
 * equals：如果两个指定的int型数组彼此相等，则返回true
 * for each循环：循环遍历数组中的所有元素，即增强的for循环，增强了对数组、集合的处理能力
 * for each循环语句显得更加简洁，不必为下标值而分心，不会出现下标越界的问题。
 */

public class ArrayMethods {

	public static void main(String[] args) {
		//创建数组a、b、c，其中b、c是调用copyOf方法分别拷贝a的部分和全部元素
		int[] a = {3, 5, 1, 6, 0, 8, 7, 2, 4};
		int[] b = Arrays.copyOfRange(a, 3, 6);
		int[] c = Arrays.copyOf(a, a.length);
		
		//打印a、b、c数组的元素，用for each循环
		System.out.println("创建数组a、b、c：");
		System.out.print("数组a：");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "数组b：");
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "数组c：");
		for (int i : c) {
			System.out.print(i + " ");
		}
		System.out.println("\r" + "**********************************");
		
		//调用sort方法对数组进行部分或全部的排序
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c, 2, 5);
		
		//输出排序后的数组元素
		System.out.println("对数组进行排序，其中c为部分排序：");
		System.out.print("排序后的数组a：");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "排序后的数组b：");
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "排序后的数组c，只对第3到第6个元素进行了排序：");
		for (int i : c) {
			System.out.print(i + " ");
		}
		System.out.println("\r" + "********************************");
		
		//搜索指定的值
		int a6 = Arrays.binarySearch(a, 6);
		System.out.println("数组a中6的位置是在第" + a6 + "个位置。");
		System.out.println("*************************************");
		
		//比较两个数组是否相等
		System.out.println("比较a、c两个数组是否相等：");
		boolean flag = Arrays.equals(a, b);
		System.out.println("数组a" + ((flag) ? "等于" : "不等于") + "数组b");
	}

}
