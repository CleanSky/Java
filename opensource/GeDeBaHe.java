package com.bisn.opensource;

import java.util.Scanner;

/*
 * ��°ͺղ��룺��һ����2��ż������д����������֮��
 */

public class GeDeBaHe {
	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		System.out.println("��������һ������2��ż����");
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
 * �ж�һ�������Ƿ�Ϊ��������
 */
class Prime {
	//�ж�����
	boolean b(int i) {
		for (int j = 2; j <= i / 2; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		
		return true;
	}
}
