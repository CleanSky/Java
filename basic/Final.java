package com.bisn.basic;

/*
 * final��ʾ���յġ�����ġ�final���η����������ࡢ������ԡ������������еľֲ������ȣ����ҹ��ܸ�����ͬ��
 * 
 * final�������ʾ�����յ��࣬���ܱ��̳У�
 * final�������ԣ���ʾ�����ǲ����ֵ��
 * final���η�������ʾ�����յķ�������������д��
 * final���ξֲ���������ʾֻ��һ�θ�ֵ����ֵ��Ͳ����ٱ��ˣ�
 * 
 * final�����Ա��븳��ֵ��һ��Ҫ�ڹ��������֮ǰ���г�ʼ����
 * 
 * final���������������͵����ݡ�
 * ���������������ͣ�һ����ֵ������������������������һ�����󣬼���������ǲ��ܸ��ĵġ�
 * �������޸����ö���ĳ�Ա�������������޸�final���η������������õĶ���
 */

public class Final {
	final int a1 = 10;//��������ʼ��int�͵ĳ�Ա����a1
	final int a2;
	final int a3;
	final Employee e = new Employee();//����һ��final�͵�����
	
	{
		a2 = 20;//�ڴ�����г�ʼ��a2
	}
	
	public Final() {//�ڹ��췽���г�ʼ��a3
		a3 = 30;
	}
	
	public void show() {
		//a2 = 50;//ϵͳ��ʾfinal�͵�a2�ǲ��ܱ����¸�ֵ��
		System.out.println("a1 = " + a1 + ", a2 = " + a2 + ", a3 = " + a3);
	}
	
	public void setSalary() {
		System.out.println("��ʼ����Ϊ��" + e.salary);
		e.salary = 4000;
		System.out.println("�ǹ��ʺ�Ϊ��" + e.salary);
	}
	
	public static void main(String[] args) {
		Final f = new Final();//����Final����
		f.show();
		f.setSalary();
	}

	class Employee {
		int salary = 2500;
	}
}
