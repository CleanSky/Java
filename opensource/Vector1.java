package com.bisn.opensource;

import java.util.*;

/*
 * Vector��ָ����ʽ����
 */

class MyCompare implements Comparator // ʵ��Comparator�������Լ��ıȽϷ���
{
	public int compare(Object o1, Object o2) {
		Elem e1 = (Elem) o1;
		Elem e2 = (Elem) o2;

		if (e1.get() > e2.get())// �����Ƚ��ǽ���,�����-1�ĳ�1��������.
		{
			return -1;
		} else if (e1.get() < e2.get()) {
			return 1;
		} else {
			return 0;
		}
	}
}

class Elem {
	private int iVal;

	public Elem(int i) {
		this.iVal = i;
	}

	public int get() {
		return this.iVal;
	}
}

public class Vector1 {
	public static void main(String[] args) {
		List v = new Vector();
		v.add(new Elem(1));
		v.add(new Elem(22));
		v.add(new Elem(3));
		v.add(new Elem(14));
		Comparator ct = new MyCompare();
		Collections.sort(v, ct);
		for (int i = 0; i < v.size(); i++)
			System.out.println(((Elem) v.get(i)).get());
	}
}
