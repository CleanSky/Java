package com.bisn.opensource;

/*
 * ����Java����žų˷���
 */

public class Double_Nine_Multiply {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("\t" + j + "x" + i + "=" + j * i);
			}
			
			System.out.println();
		}
	}
}
