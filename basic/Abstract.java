package com.bisn.basic;

/*
 * abstract表示抽象的，可以修饰类和方法，分别叫做抽象类和抽象方法。
 * 抽象类不能实例化，不能生成抽象类的对象，但能定义一个引用。
 * 抽象方法中只有方法的声明，没有方法体，取而代之的是分号，表示声明的结束。
 * 
 * 当知道某个类中一定有某个方法，而在这个类的层次中还无法实现或者没有固定的实现时，应该写抽象方法。如动物用几条腿跑等。
 * 
 * 写抽象类和抽象方法时注意以下两点：
 * 一个类中只要包含抽象方法，那么这个类就必须被定义为抽象类，反之，即使一个类不包括任何抽象方法，这个类仍然可以被定义为抽象类。
 * abstract和final不能被同时使用，因为这两个关键字有相反的含义。private和abstract也不能被同时修饰方法。
 */

public class Abstract {

	public static void main(String[] args) {
		Chihuahua chihuahua = new Chihuahua();
		chihuahua.eat();
		chihuahua.run();
	}

}

abstract class Animal {
	public abstract void eat();//定义抽象方法run
}

abstract class Dogs extends Animal {
	public abstract void run();
}

class Chihuahua extends Dogs {
	@Override
	public void run() {
		System.out.println("吉娃娃活泼可爱，向前跑");
	}
	@Override
	public void eat() {
		System.out.println("吉娃娃吃的好少");
	}
}
