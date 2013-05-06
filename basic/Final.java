package com.bisn.basic;

/*
 * final表示最终的、不变的。final修饰符可以修饰类、类的属性、方法、方法中的局部变量等，而且功能各不相同。
 * 
 * final修饰类表示是最终的类，不能被继承；
 * final修饰属性，表示属性是不变的值；
 * final修饰方法，表示是最终的方法，不允许被重写；
 * final修饰局部变量，表示只能一次赋值，赋值后就不能再变了；
 * 
 * final的属性必须赋初值，一定要在构造器完成之前进行初始化。
 * 
 * final可以修饰引用类型的数据。
 * 对于引用数据类型，一旦赋值，将不能用来重新引用另外一个对象，即这个引用是不能更改的。
 * 但可以修改引用对象的成员变量，即可以修改final修饰符的引用所引用的对象。
 */

public class Final {
	final int a1 = 10;//声明并初始化int型的成员变量a1
	final int a2;
	final int a3;
	final Employee e = new Employee();//声明一个final型的引用
	
	{
		a2 = 20;//在代码块中初始化a2
	}
	
	public Final() {//在构造方法中初始化a3
		a3 = 30;
	}
	
	public void show() {
		//a2 = 50;//系统提示final型的a2是不能被重新赋值的
		System.out.println("a1 = " + a1 + ", a2 = " + a2 + ", a3 = " + a3);
	}
	
	public void setSalary() {
		System.out.println("初始工资为：" + e.salary);
		e.salary = 4000;
		System.out.println("涨工资后为：" + e.salary);
	}
	
	public static void main(String[] args) {
		Final f = new Final();//创建Final对象
		f.show();
		f.setSalary();
	}

	class Employee {
		int salary = 2500;
	}
}
