package com.bisn.basic;

public class MyPet {

	public static void main(String[] args) {
		Pet1 myPet = new Pet1();
		myPet.show();
		myPet.speak();
		myPet.eat("狗粮");
		myPet.jump(15.5);
		myPet.playWithOwner("康夫");
		
		Pet2 myPet2 = new Pet2("佳佳", 3, "黑", 4.5);
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
		System.out.println(name + "说：我会说话，可是人类听不懂我说的话。");
	}
	
	public void show() {
		System.out.println(name + "，今年" + age + "岁，是" + color + "颜色的，体重是：" + weight + "公斤。");
	}
	
	public void eat(String food) {
		System.out.println(name + "喜欢吃" + food);
	}
	
	public void playWithOwner(String ownerName){
		System.out.println(ownerName + "和他的宠物" + name + "玩的好开心啊！");
	}
	
	public void jump(double height) {
		if (height > 10.0) {
			System.out.println(name + "真厉害，跳的好高啊！它的体重只有" + weight + "公斤。");
		} else {
			System.out.println(name + "太胖了，跳不动哟！它的体重竟然有" + weight +"公斤");
		}
	}
}

class Pet2 {
	private String name;
	private int age;
	private String color;
	private double weight;
	
	//构造方法
	public Pet2(String name, int age, String color, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.weight = weight;
	}
	
	//封装
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
		System.out.println(name + "，今年" + age + "岁，是" + color + "颜色的，体重是：" + weight + "公斤。");
	}
	
	//重载show方法——overload
	public void show(String ownerName) {
		System.out.println(name + "的主人" + ownerName + "带它去参加比赛了。");
	}
}