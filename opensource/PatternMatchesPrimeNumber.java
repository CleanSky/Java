package com.bisn.opensource;

/*
 * ����������ʽ�ж�������������
 * ^1?$�������ų�1����Ϊ1Ҳ��ƥ��^(11+?)\1+$
 * ^(11+?)\1+$������˼�����ƥ�����������ʽ����������\1+�ظ���1�Σ���ô�ܱ�2�������ظ���n-1��,���ܱ�n��������Ȼ����������
 */

public class PatternMatchesPrimeNumber {

	public static void main(String[] args) {
		String regex = "^1?$|^(11+?)\\1+$";// ������ʽ
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < 1000; i++) {
			sb.append("1");
			if (!sb.toString().matches(regex)) {
				System.out.println(i);
			}
		}
	}

}
