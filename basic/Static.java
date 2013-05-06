package com.bisn.basic;

/*
 * 静态成员主要在以下两种情况下使用
 * 如果一个方法总是以相同的方式运行，其行为和结果并不依赖于任何对象，也不需要创建对象就可以运行这个方法，这时完全可以由类自身来运行这个方法。
 * 当需要某个类的所有对象的信息时，如记录某个类的所有对象的个数，必须有一个依赖于类而又不是依赖于对象的变量来记录这个信息。依赖于对象的成员变量是不可能解决此类问题的。
 * 
 * 当static修饰属性时，表示这个属性是一个静态的属性，即类属性，而不是一个描述个体特征的实例属性。
 * 静态属性和实例属性的差别在于：
 * static属性在整个类中只有一份，而实例属性是有多少个对象就有多少个值。
 * static属性在类加载时，被实例化，而实例属性在生成对象时被实例化。
 * 对static属性的访问，是直接通过类名后加属性名，并且可以在没有生成任何对象之前访问，与对象无关。
 * 
 * 当static修饰方法时，表示这个方法是一个静态的方法，即用来描述整个类的行为，而不是描写某个对象的行为。
 * 静态方法里只能访问本类方法中的静态成员，不能直接访问非静态的属性和方法，因为静态方法是不依赖于对象的。
 * 静态方法中也不能出现this关键字，因为this是针对对象而言的。
 * 
 * static可以修饰一段代码块，称为静态代码块。
 * 静态代码块表示这段代码在类加载的时候被执行，是一个类中最先运行的代码，其在构造方法运行之前就运行了。
 */

public class Static {

	public static int count = 0;
	public int selfCount = 0;
	public static int a1 = 10;
	public static int a2;
	
	//静态代码块，将会最先得到运行
	static {
		System.out.println("静态代码块");
	}
	
	//构造方法，在类构造对象的时候运行
	public Static() {
		count++;
		selfCount++;
		a1 = 20;
		a2 = 20;
		System.out.println("构造方法！");
	}
	
	public static void main(String[] args) {
		Static s1 = new Static();
		Static s2 = new Static();
		Static s3 = new Static();
		
		System.out.println("主方法输出语句！");
		System.out.println("静态成员变量count的值为：" + Static.count);
		System.out.println("对象s1、s2、s3的selfCount值分别为：selfCount = " + s1.selfCount + "、" + s2.selfCount + "、" + s3.selfCount);
		System.out.println("静态变量a1 = " + a1 + "，静态变量a2 = " + a2);
	}

}
