package com.bisn.basic;

/*
 * abstract��ʾ����ģ�����������ͷ������ֱ����������ͳ��󷽷���
 * �����಻��ʵ�������������ɳ�����Ķ��󣬵��ܶ���һ�����á�
 * ���󷽷���ֻ�з�����������û�з����壬ȡ����֮���Ƿֺţ���ʾ�����Ľ�����
 * 
 * ��֪��ĳ������һ����ĳ�����������������Ĳ���л��޷�ʵ�ֻ���û�й̶���ʵ��ʱ��Ӧ��д���󷽷����綯���ü������ܵȡ�
 * 
 * д������ͳ��󷽷�ʱע���������㣺
 * һ������ֻҪ�������󷽷�����ô�����ͱ��뱻����Ϊ�����࣬��֮����ʹһ���಻�����κγ��󷽷����������Ȼ���Ա�����Ϊ�����ࡣ
 * abstract��final���ܱ�ͬʱʹ�ã���Ϊ�������ؼ������෴�ĺ��塣private��abstractҲ���ܱ�ͬʱ���η�����
 */

public class Abstract {

	public static void main(String[] args) {
		Chihuahua chihuahua = new Chihuahua();
		chihuahua.eat();
		chihuahua.run();
	}

}

abstract class Animal {
	public abstract void eat();//������󷽷�run
}

abstract class Dogs extends Animal {
	public abstract void run();
}

class Chihuahua extends Dogs {
	@Override
	public void run() {
		System.out.println("�����޻��ÿɰ�����ǰ��");
	}
	@Override
	public void eat() {
		System.out.println("�����޳Եĺ���");
	}
}
