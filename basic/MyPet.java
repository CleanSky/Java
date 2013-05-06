package com.bisn.basic;

public class MyPet {

	public static void main(String[] args) {
		Pet1 myPet = new Pet1();
		myPet.show();
		myPet.speak();
		myPet.eat("����");
		myPet.jump(15.5);
		myPet.playWithOwner("����");
		
		Pet2 myPet2 = new Pet2("�Ѽ�", 3, "��", 4.5);
		myPet2.show();
		myPet2.show("Bisn");
	}

}

class Pet1 {
	public String name = "gougou";
	public int age = 3;
	public String color = "black";
	public double weight = 5.3;
	
	public void speak() {
		System.out.println(name + "˵���һ�˵��������������������˵�Ļ���");
	}
	
	public void show() {
		System.out.println(name + "������" + age + "�꣬��" + color + "��ɫ�ģ������ǣ�" + weight + "���");
	}
	
	public void eat(String food) {
		System.out.println(name + "ϲ����" + food);
	}
	
	public void playWithOwner(String ownerName){
		System.out.println(ownerName + "�����ĳ���" + name + "��ĺÿ��İ���");
	}
	
	public void jump(double height) {
		if (height > 10.0) {
			System.out.println(name + "�����������ĺø߰�����������ֻ��" + weight + "���");
		} else {
			System.out.println(name + "̫���ˣ�������Ӵ���������ؾ�Ȼ��" + weight +"����");
		}
	}
}

class Pet2 {
	private String name;
	private int age;
	private String color;
	private double weight;
	
	//���췽��
	public Pet2(String name, int age, String color, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.weight = weight;
	}
	
	//��װ
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void show() {
		System.out.println(name + "������" + age + "�꣬��" + color + "��ɫ�ģ������ǣ�" + weight + "���");
	}
	
	//����show��������overload
	public void show(String ownerName) {
		System.out.println(name + "������" + ownerName + "����ȥ�μӱ����ˡ�");
	}
}