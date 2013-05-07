package com.bisn.basic;

/*
 * 接口主要是用来描述类应该拥有什么样的功能，可充当什么样的角色，但并不给出每个功能的具体实现，具体实现由接口的实现类来进行。
 * 接口的实现类只要满足接口的要求即可。
 * 
 * 接口和类的区别如下：
 * 接口中的方法都是公开的抽象方法（public abstract），并且不需要提供public和abstract关键字。
 * 无论编程时是否加上“public static final”，接口中的属性都是公开静态常量。
 * 接口中没有构造方法。
 * 类与接口之间的代码复用关系叫实现而不叫继承。实现是implements，而不是extends。
 * 一个类可以实现多个接口，实现多个接口时用“,”隔开，可以看成是一种变相的继承。
 * 构造子类对象时不需要构造接口对象，接口也不能构造对象。
 * Java中正是使用接口来达到多继承的目的的。
 * 
 * 如果一个类，它的父类也是一个类，那么就是继承，而且必须是单继承。
 * 如果一个类去继承一个接口，要用implements关键字。
 * 如果一个接口继承了一个接口，那么也是继承，而且一个接口可以继承多个接口，语法与类的继承语法相同。
 * 接口只能继承接口，不可以继承类，不存在这种关系。
 * 
 * 对于Java来说，接口编程实现了重大的突破，在编程中应该尽量基于接口的编程，不要基于实例的编程。
 * 接口编程的意义：
 * 接口实现了多继承。
 * 用接口可以实现混合类型（主类型，副类型），Java中可以通过接口分出主次类型。主类型使用继承，副类型使用接口。
 * 接口进一步深化了标准的思想，接口本身就是一个标准。
 * 接口编程起到了降低耦合性的作用，接口可以使方法的定义和实现相分离，即接口的制定者和实现者相分离。
 * 接口可以用于降低模块间或系统间的耦合性。
 * 针对接口编程可以屏蔽不同实现间的差异，看到的知识实现好的功能。
 * 
 * 内聚：系统或类独立完成某项任务的能力。不需要外接过多的干预就能完成任务，称为高内聚。
 * 类与类之间、模块与模块之间关联关系的复杂度，称为耦合度。耦合度应该降低，以使系统更加稳定和更好维护。
 * 软件编程追求的是高内聚、低耦合。
 * 
 */

public class Interface {

	public static void main(String[] args) {
		String[][] data = {{"姓名", "性别", "年龄", "工资"}, 
							{"张龙", "男", "24", "3000"}, 
							{"赵虎", "男", "26", "3020"}, 
							{"王朝", "男", "23", "2780"}, 
							{"马汉", "男", "25", "4000"}, 
							{"展昭", "男", "30", "5999"}, 
							{"包拯", "男", "32", "100000"}};
		
		//这里使用了多态，接口变量必须引用实现了接口的类的对象
		TableModel model = new TableModelA(data);
		model.print();
	}

}

//接口的声明
interface TableModel {
	public int getColNumber();
	public int getRowNumber();
	public String getValue(int row, int col);
	public String getColName(int col);
	public void print();
}

//接口的实现
class TableModelA implements TableModel {
	String[][] data;//定义传入数组data
	
	public TableModelA(String[][] data) {//定义TableModelA构造方法
		this.data = data;
	}
	
	//按接口的要求实现其方法
	public int getColNumber() {
		return data[0].length;
	}
	
	public int getRowNumber() {
		return data.length - 1;
	}
	
	public String getValue(int row, int col) {
		return data[row + 1][col];
	}
	
	public String getColName(int col) {
		return data[0][col];
	}
	
	public void print() {
		System.out.println("第0列名称：" + this.getColName(0));
		System.out.println("第0列的长度：" + this.getColNumber());
		System.out.println("第0行第0列的值：" + this.getValue(0, 0));
	}
}
