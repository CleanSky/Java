package com.bisn.basic;

import java.util.Arrays;

/*
 * ��������ķ���
 * copyOfRange����ָ�������ָ����Χ���Ƶ�һ��������
 * copyOf������ָ�������飬��ȡ����0��䣨���б�Ҫ����ʹ��������ָ������
 * sort����ָ��int�������ָ����Χ��������������
 * binarySearch��ʹ�ö���������������ָ����int�����飬�Ի��ָ����ֵ
 * equals���������ָ����int������˴���ȣ��򷵻�true
 * for eachѭ����ѭ�����������е�����Ԫ�أ�����ǿ��forѭ������ǿ�˶����顢���ϵĴ�������
 * for eachѭ������Եø��Ӽ�࣬����Ϊ�±�ֵ�����ģ���������±�Խ������⡣
 */

public class ArrayMethods {

	public static void main(String[] args) {
		//��������a��b��c������b��c�ǵ���copyOf�����ֱ𿽱�a�Ĳ��ֺ�ȫ��Ԫ��
		int[] a = {3, 5, 1, 6, 0, 8, 7, 2, 4};
		int[] b = Arrays.copyOfRange(a, 3, 6);
		int[] c = Arrays.copyOf(a, a.length);
		
		//��ӡa��b��c�����Ԫ�أ���for eachѭ��
		System.out.println("��������a��b��c��");
		System.out.print("����a��");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "����b��");
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "����c��");
		for (int i : c) {
			System.out.print(i + " ");
		}
		System.out.println("\r" + "**********************************");
		
		//����sort������������в��ֻ�ȫ��������
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c, 2, 5);
		
		//�������������Ԫ��
		System.out.println("�����������������cΪ��������");
		System.out.print("����������a��");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "����������b��");
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.print("\r" + "����������c��ֻ�Ե�3����6��Ԫ�ؽ���������");
		for (int i : c) {
			System.out.print(i + " ");
		}
		System.out.println("\r" + "********************************");
		
		//����ָ����ֵ
		int a6 = Arrays.binarySearch(a, 6);
		System.out.println("����a��6��λ�����ڵ�" + a6 + "��λ�á�");
		System.out.println("*************************************");
		
		//�Ƚ����������Ƿ����
		System.out.println("�Ƚ�a��c���������Ƿ���ȣ�");
		boolean flag = Arrays.equals(a, b);
		System.out.println("����a" + ((flag) ? "����" : "������") + "����b");
	}

}
