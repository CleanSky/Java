package com.bisn.basic;

public class MyDog {
	
	public static void main(String[] args) {
		Dog mydog = new Dog("阿贵", 3, "巧克力", 3.80, "玩具贵宾犬");
		mydog.show();
		mydog.cosmetic();
		
		//多态：方法的多态（方法的重写和重载）+ 对象的多态
		//当把子类对象当作父类对象来看时，就只能调用父类中原有定义的属性和方法，子类自己扩展的属性和方法就不能调用了。
		//当把子类对象当作父类对象来看时，如果子类重写了父类中的方法，则调用该方法时调用的是子类重写后的方法。
		Pet mydog2 = new Dog("旺财", 3, "肉包子", 3.50, "哈巴狗");
		mydog2.show();//show被子类重写了，所以调用的是子类重写的方法
		//mydog2.cosmetic();//mydog2不能调用自己独特的方法，此处子类当作父类看
		((Dog) mydog2).cosmetic();//强制转换后才可使用自己独有的方法
		
		//instanceof运算符
		if (mydog2 instanceof Dog) {
			System.out.println("mydog2是一条狗。");
		} else {
			System.out.println("mydog2不是一条狗。");
		}
	}

}

//继承
class Dog extends Pet {
	public Dog(String name, int age, String color, double weight) {
		super(name, age, color, weight);
	}
	
	private String species;//子类宠物狗有一个扩展的属性品种
	
	//重载的构造方法，将宠物狗特有的属性加进来
	public Dog(String name, int age, String color, double weight, String species) {
		super(name, age, color, weight);
		this.species = species;
	}
	
	//给宠物狗的属性species添加get和set方法
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	//写宠物狗独有的方法
	public void cosmetic() {
		System.out.println(this.getName() + "最爱做美容了。");
	}
	
	//重写父类已有的show方法
	//@Override是重写注释，如果写的方法父类没有，会标注错误提示
	@Override
	public void show() {
		System.out.println(this.getName() + "，今年" + this.getAge() + "岁，是" + this.getColor() + "颜色的" + this.getSpecies() + "，体重是：" + this.getWeight() + "公斤。");
	}
}