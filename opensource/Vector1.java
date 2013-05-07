package com.bisn.opensource;

import java.util.*;

/*
 * Vector按指定方式排序
 */

class MyCompare implements Comparator // 实现Comparator，定义自己的比较方法
{
	public int compare(Object o1, Object o2) {
		Elem e1 = (Elem) o1;
		Elem e2 = (Elem) o2;

		if (e1.get() > e2.get())// 这样比较是降序,如果把-1改成1就是升序.
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
