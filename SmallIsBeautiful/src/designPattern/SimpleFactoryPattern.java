package designPattern;

/**
 * 该程序以实际生活中的汽车为例,是对简单工厂模式的一个简单实现.
 * 利用反射机制,得到汽车类型,这样当我们需要增加一种新的汽车时,就无需再修改工厂,而只需增加要实现的类即可.
 * 即要增加什么样的汽车直接增加这个汽车的类即可,而无需改变工厂,这样达到了工厂分离的效果.
 * 
 * @author Bisn
 */
public class SimpleFactoryPattern {

	public static void main(String[] args) {
		Car c = Factory.getCarInstance("Toyota");
		if (c != null) {
			c.run();
			c.stop();
		} else {
			System.out.println("造不了这种汽车......");
		}
	}

}

/*
 * 汽车接口
 */
interface Car {
	public String name = "Car";// 接口中的属性必须显示地初始化,默认为public,static,final类型

	public void run();

	public void stop();
}

/*
 * 奔驰:实现汽车接口
 */
class Benz implements Car {

	public void run() {
		System.out.println("Benz开始启动了......");
	}

	public void stop() {
		System.out.println("Benz停车了......");
	}
}

/*
 * 福特汽车:实现汽车接口
 */
class Ford implements Car {
	public void run() {
		System.out.println("Ford开始启动了......");
	}

	public void stop() {
		System.out.println("Ford停车了......");
	}
}

/*
 * 丰田汽车:实现汽车接口
 */
class Toyota implements Car {
	public void run() {
		System.out.println("Toyota开始启动了......");
	}

	public void stop() {
		System.out.println("Toyota停车了......");
	}
}

/*
 * 工厂类
 */
class Factory {
	public static Car getCarInstance(String type) {
		Car c = null;
		try {
			c = (Car) Class.forName("designPattern." + type).newInstance();// 利用反射得到汽车类型
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return c;
	}
}
