package com.bisn.opensource;

import java.util.ArrayList;
import java.util.List;

/*
 * 斐波那契序列的三种实现之间的性能和内存比较
 */

public class Fibonacci {

	/**
	 * 递归算法：不断调用自身实现深度计算
	 * 
	 */
	public static Long recursiveCompute(int n) {
		if (n <= 2)
			return 1L;
		else
			return recursiveCompute(n - 1) + recursiveCompute(n - 2);
	}

	/**
	 * 非递归cache算法：用一个List缓存所有从1~n的Fibonacci值
	 * 
	 */
	public static Long cacheCompute(int n) {
		if (n <= 2)
			return 1L;

		List<Long> results = new ArrayList<Long>();
		results.add(1L);
		results.add(1L);

		int length = -1;
		while ((length = results.size()) < n)
			results.add(results.get(length - 2) + results.get(length - 1));
		
		return results.get(n - 1);
	}

	/**
	 * 非递归swap算法：只用两个变量l1、l2来保存Fibonacci值，不断update和swap
	 * 
	 */
	public static Long swapCompute(int n) {
		if (n <= 2)
			return 1L;

		long l1 = 1;
		long l2 = 1;

		int index = 2;
		while (index < n - 1) {
			long l = l2;
			l2 = l1 + l2;
			l1 = l;
			index++;
		}
		
		return l1 + l2;
	}

	public static void testTime(int n) {
		Long result = 0L;

		long start = System.nanoTime();
		result = recursiveCompute(n);
		long end = System.nanoTime();
		System.out.println("Recursive Compute: " + result + "\tUse Time: "
				+ (end - start));

		start = System.nanoTime();
		result = cacheCompute(n);
		end = System.nanoTime();
		System.out.println("Cache Compute: " + result + "\tUse Time: "
				+ (end - start));

		start = System.nanoTime();
		result = swapCompute(n);
		end = System.nanoTime();
		System.out.println("Swap Compute: " + result + "\tUse Time: "
				+ (end - start));
	}

	public static void main(String[] args) {
		System.out.println("Compute Fibonacci(10):");
		testTime(10);
		System.out.println("\nCompute Fibonacci(20):");
		testTime(20);
		System.out.println("\nCompute Fibonacci(30):");
		testTime(30);
		System.out.println("\nCompute Fibonacci(40):");
		testTime(40);
		System.out.println("\nCompute Fibonacci(50):");
		testTime(50);
	}

}