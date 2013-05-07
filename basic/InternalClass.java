package com.bisn.basic;

/*
 * Java中的类可以包含方法、成员变量、语句块，甚至还可以包含类，这种定义在另一个类内部的类称为内部类。
 * 内部类根据使用情况分为4种：成员内部类、局部内部类、静态内部类、匿名内部类。
 * 
 * 
 * 成员内部类
 * 成员内部类，是一个可以看成是外部类的非静态成员的内部类。
 * 成员内部类可以访问外部类的私有成员或属性。
 * 外部类不能访问成员内部类中的私有属性。
 * 成员内部类是一个编译时的概念，一旦编译成功，就会成为与外部类完全不同的类。
 * 内部类和外部类在编译时是两个不同的类，内部类对外部类没有任何依赖。
 * 
 * 在外部类的内部创建一个内部类的对象可以直接使用inner i = new inner();(inner代表内部类的类名）
 * 在外部类的外部创建一个内部类的对象，需要首先建立一个外部类对象，然后再生成一个内部类对象。
 * 
 * 
 * 局部内部类
 * 局部内部类，是一个只有在局部有效的内部类。
 * 局部内部类被定义在方法中。
 * 局部内部类前不加修饰符public和private，其范围为定义它的代码块。
 * 局部内部类可以访问外部类的私有实例变量和局部常量（即final型的）。
 * 在外部类的外部不能直接访问局部内部类，即局部内部类对外是不可见的。
 * 为解决类外不能访问局部内部类的问题，可以通过局部内部类和接口达到一个强制的弱耦合关系，用局部内部类来实现接口，并在方法中返回接口类型，这样既可以使局部内部类不可见，屏蔽实现类的可见性，又可以在类的外部访问到内部类的方法。
 * 
 * 
 * 静态内部类
 * 静态内部类，其实已经脱离了外部类，实质是一个放置在别的类内部的普通类，关键字static只是说明其在创建对象时不依赖于外部类对象的存在，并不是说这个类本身是静态的。
 * 静态内部类不可以用private进行定义，在内部类的声明前面要加上static关键字。
 * 静态内部类只能访问外部类的静态成员，不能访问外部类的非静态成员。
 * 静态内部类的对象可以直接生成，而不需要外部类的对象来生成。
 * 非静态内部类是外部类对象组成的一部分，主要是辅助外部类对象工作的，与外部类对象存在着对成员变量的共享关系。
 * 
 * 
 * 匿名内部类
 * 匿名内部类，是一种特殊的局部内部类，这种内部类没有类名。该类适用于只使用一次且不需要多次创建对象的类。
 * 匿名内部类在声明的同时创建对象，匿名内部类的声明要么是基于继承，要么是实现接口。
 * 匿名内部类是唯一一种没有构造方法的类。
 * 大部分匿名内部类用于接口回调。
 * 匿名内部类在编译时由系统自动起名为Out $1.class。
 * 匿名内部类用于继承其他类或是实现接口，且不需要增加额外的方法，只是对继承方法的实现或是重写。
 */

public class InternalClass {

	private String name = "小强";//定义外部类属性name
	private static String address = "北京";//定义静态属性address
	
	public void m1() {//定义外部类方法m1
		System.out.println("外部类的方法m1");
	}
	
	//成员内部类
	public class InnerA {
		public InnerA() {//构造方法
			
		}
		
		String name = "大宝";//定义成员内部类的属性name
		
		public void m2() {//定义成员内部类的方法m2
			//调用外部类的属性，有两种写法，可以调用私有属性
			System.out.println("外部类的name = " + InternalClass.this.name);
			System.out.println("外部类的address = " + address);
			//调用成员内部类的属性用this.
			System.out.println("外部类的内部类的name = " + this.name);
		}
	}
	
	//静态内部类InnerC
	public static class InnerC {
		public void m3() {
			//静态内部类只能调用外部类的静态属性，不能调用非静态属性
			//System.out.println("name = " + name);
			System.out.println("静态内部类InnerC调用InternalClass的address = " + address);
		}
	}
	
	public static void main(String[] args) {
		InternalClass out = new InternalClass();//创建外部类的对象out
		out.m1();
		InternalClass.InnerA inn = out.new InnerA();//由out的对象创建内部类Inner的对象
		inn.m2();
		
		OuterB outb = new OuterB();
		//通过外部类对象调用方法m1，返回接口类型，达到调用局部内部类方法的目的
		MyInter obj = outb.m1();
		obj.m3();
		obj.m4();
		
		//静态内部类可以在不生成外部类对象的情况下直接生成内部类的对象
		InternalClass.InnerC innc = new InternalClass.InnerC();
		innc.m3();
		
		//匿名内部类
		AbstractFather af = new AbstractFather() {
			{
				count = (int)(100 * Math.random());//定义语句块
			}
			
			public void m() {//实现父类的方法
				System.out.println("您的号码是：" + count);
			}
		};
		
		af.m();
	}

}

class OuterB {
	private int a = 10;
	public MyInter m1() {
		int b = 20;
		final int c = 30;
		
		//局部内部类
		class InnerB implements MyInter {
			/*
			 * 局部内部类，并且实现了MyInter接口
			 * 实现接口的抽象方法m3、m4
			 */
			public void m3() {
				System.out.println("局部内部类InnerB的m3方法调用外部类OuterB的变量a = " + a);
				//非final的局部变量不能访问
				//System.out.println("内部类InnerB的m3方法调用局部变量b = " + b);
			}
			
			public void m4() {
				System.out.println("局部内部类InnerB的m4方法调用局部变量c = " + c);
			}
		}
		
		return new InnerB();
	}
}

interface MyInter {//接口MyInter
	public void m3();
	public void m4();
}

abstract class AbstractFather {
	int count;
	abstract void m();
}
