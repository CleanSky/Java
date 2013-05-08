package com.bisn.basic;

import java.lang.reflect.*;

/*
 * 反射可以破坏泛型、破坏封装，从而访问类的成员，可以在运行时装载类和生成实例，调用属性和方法，对程序进行动态的控制。
 * 反射是现实中的克隆技术。
 * 
 * Class类是一个特别的类，用来存储和一个类有关的全部信息的类，与对象没有关系。
 * Class类属于java.lang包，用来保存和记录某一个类的信息，如构造方法、方法、成员变量等。
 * 在Java程序运行过程中，每个类被加载都可以在内存中生成一个相应的Class对象。
 * 
 * 已经有一个类，用该类对应的反射可以提取该类的所有信息，并根据这些信息可以克隆一个类的对象。
 */

public class Reflect {

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("com.bisn.basic.Pet");
			// 创建、加载类的对象
			Object obj = c.newInstance();// 用类对象调用，只能调用无参的构造方法

			// 用Constructor对象类实例化，可以调用指定参数的构造方法
			Constructor con = c.getDeclaredConstructor(String.class, int.class,
					String.class, double.class);
			Object obj2 = con.newInstance("盼盼", 8, "黑色", 5.23);

			// 调用对象属性name
			Field f = c.getDeclaredField("name");// 调用对象属性name
			f.setAccessible(true);// 设置可以访问私有成员
			String name = (String) f.get(obj2);// 得到obj2的姓名
			System.out.println("obj2的name是：" + name);
			f.set(obj2, "贝贝");// 修改属性值

			Method m = c.getDeclaredMethod("show", null);// 调用对象的方法
			m.setAccessible(true);// 忽略所有访问权限，即可以访问私有成员
			Object o = m.invoke(obj2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
