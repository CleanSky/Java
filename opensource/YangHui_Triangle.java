package com.bisn.opensource;

/*
 * ����������
 */

public class YangHui_Triangle {

	public static void yh_Triangle(int array[][], int rows) { // ������������������
		for (int i = 0; i <= rows; i++) { // ��ѭ��
			for (int j = 0; j <= array[i].length - 1; j++) { // ��ѭ��
				if (i == 0 || j == 0 || j == array[i].length - 1)
					array[i][j] = 1; // ������Ԫ����Ϊ1
				else
					// Ԫ��ֵΪ�����Ϸ�Ԫ�������Ͻ�Ԫ��֮��
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
			}
		}
		for (int i = 0; i <= rows; i++) { // ��ѭ��
			for (int j = 0; j <= array[i].length - 1; j++)
				// ��ѭ��
				System.out.print(array[i][j] + " "); // �������Ԫ��
			System.out.println(); // ����
		}
	}

	public static void main(String args[]) {
		final int rows = 7; // ��������
		int array[][] = new int[rows + 1][]; // ������ά����,����Ϊ8
		for (int i = 0; i <= rows; i++) { // ѭ����ʼ������
			array[i] = new int[i + 1];
		}
		
		System.out.println("����������£�");
		yh_Triangle(array, rows); // ���÷�����ʾ�������
	}
}
