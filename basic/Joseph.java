package com.bisn.basic;

import java.util.Scanner;

/*
 * ������ʵ��Լɪ���Ȧ����
 * ��m����Χ��һ����β������Ȧ�������ӵ�1���˿�ʼ����1��ʼ������n����ʣ�µ��˼�����ʼ��1������ֱ�����е��˶���ȦΪֹ��
 * ���ڸ�����m��n����������˵ĳ�Ȧ˳��
 */

public class Joseph {
	
	public static void main(String[] args) {
		//��ʾ����������
		System.out.print("�������������Ϸ��������");
		Scanner sca = new Scanner(System.in);
		int m = sca.nextInt();
		
		//��ʾ����Ҫ��Ȧ����ֵ
		System.out.print("������Ҫ��Ȧ����ֵ��");
		int n = sca.nextInt();
		
		System.out.println("����Ȧ�Ĵ��������ţ�");
		
		int[] a = new int[m];//��������a��Ϊint�ͣ���m��Ԫ��
		int len = m;//Ȧ�е�ǰ��������Ϊ�����Ԫ����
		
		//��ѭ����ʽ������Ԫ�ظ�ֵ
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		
		//��i��ΪԪ���±꣬j����ǰҪ������
		int i = 0;
		int j = 1;
		
		while (len > 0) {
			if (a[i %m] > 0) {
				if (j % n == 0) {
					//�ҵ�Ҫ��Ȧ���ˣ�����Ȧ�е�������1
					System.out.println(a[i % m] + " ");
					a[i % m] = -1;//����Ȧ�����Ӧλ������-1
					j = 1;//���±�������1��ʼ
					i++;
					len--;//Ȧ��������1
				} else {
					//����a[i % m] > 0����������j % n == 0�����
					//���λ�����ˣ���������������n��������
					i++;
					j++;
				}
			} else {
				//������a[i % m] > 0�������������λ��
				//������һ������j���Լӣ������λ�ò�����
				i++;
			}
		}
	}

}
