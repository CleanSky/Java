package com.bisn.basic;

import java.util.Scanner;

/*
 * ��ȡ�û�����
 */

public class ScannerTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);//�����������
		System.out.print("������������ֵ���ַ�����");//��ʾ����������ֵ���ַ���
		String g = in.next();
		System.out.println("��������ǣ�" + g);
	}
}
