package com.bisn.opensource;

import java.util.concurrent.TimeUnit;

/*
 * TimeUnit��ʾ������Ԫ���ȵ�ʱ��Σ����ṩ����Щ��Ԫ�н��п絥Ԫת����ִ�м�ʱ���ӳٲ�����ʵ�ù��߷�����
 * TimeUnit��ά��ʱ����Ϣ��������������֯��ʹ�ÿ��ܿ���������ĵ���ά����ʱ���ʾ��ʽ��
 * TimeUnit��Ҫ����֪ͨ����ʱ��ķ�����ν��͸����ļ�ʱ������
 */

public class TimeUnitDemo {
	public static void main(String[] args) {
		TimeUnit tu = TimeUnit.DAYS;

		System.out.println(tu.toDays(1));
		System.out.println(tu.toHours(1));
		System.out.println(tu.toMinutes(1));
	}
}
