package com.bisn.basic;

public class Pet {
	private String name;
	private int age;
	private String color;
	private double weight;
	
	//构造方法
	public Pet(String name, int age, String color, double weight) {
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
}
