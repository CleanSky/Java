package com.bisn.basic;

import java.io.IOException;

/*
 * Java中异常对象都是由Throwable类继承而来的，分为Error和Exception两类，Exception又分为RuntimeException异常和非RuntimeException异常。
 * 
 * Error类层次的结构主要描述了Java运行时系统的内部错误和资源耗尽等错误，如硬件错误、输入错误数据、系统崩溃等。
 * RuntimeException的异常指的是运行时异常，也称为未检查异常，一般是由于程序员自己的问题造成的，如错误的类型转换、数组访问越界、访问空指针等。
 * 非RuntimeException异常，也称为已检查异常。常见的已检查异常主要有以下几种：java.io.IOException(IO异常，输入输出设备不存在，如在文件的末尾读取数据)、java.io.FileNotFoundException(文件未找到异常)和java.lang.ClassNotFoundException(动态地装载某个类时，找不到此类)。
 * 
 * 对于已检查异常必须处理，而对于未检查异常则可处理也可不处理。
 * 
 * try/catch/finally
 * try控制的范围要根据操作的连动性和相关性进行控制，如果前面的程序代码块抛出的错误影响后面程序代码的运行，那么就说这两个程序代码存在关联，应放在同一个try中。
 * finally语句块中的语句无论在什么情况下都会被执行，经常会写一些释放资源的语句。
 * 
 * finally和catch语句块是可选的语句，但是它们不能同时省略。
 * 
 * 如果多个catch语句块中所指定的异常类型级别相同或者没有任何派生关系，则catch语句 的排列无顺序。
 * 如果多个catch语句块中所指定的异常类型相互之间有派生关系，则必须将子类型的异常写在上面，父类型的异常写在下面。
 * 
 * 
 * 捕获异常知识异常处理的一种方式，对于异常，应在合适的地方进行处理，即未必是有异常就要捕获，也可以抛出异常。
 * 如果程序有能力解决异常，可以用try/catch方法主动去捕获和处理异常。
 * 如果程序没能力解决异常，则向上抛出异常，直到抛到能处理异常的位置（即放在具备对异常进行处理能力的位置）。
 * 
 * throws用来声明方法将有可能抛出的异常，将可能抛出的异常列在throws后面，用逗号隔开。
 * throw用于抛出异常对象，但其后只能跟一个异常对象的引用，即同一时刻只能抛出一个异常。
 * 异常是沿着方法的调用链反向传递的。
 */

public class ExceptionTest {

	public static void test(int num) throws IOException, BelowZeroException {
		if (num < 0) {
			throw new BelowZeroException(num + "小于0！");
		} else {
			System.out.println(num + "大于等于0！");
		}
	}

	
	public static void main(String[] args) throws IOException, BelowZeroException {
		//写for循环和switch分支语句，依次运行会抛出异常的语句
		for (int i = 0; i < 5; i++) {
			int j = 0;
			try {
				System.out.println("本条是正常语句，没有异常！");//正常语句
				//分支语句，每次运行1条语句，前4条抛出异常，最后一条没抛出异常
				switch (i) {
				case 0:
					int zero = 0;//数学方法异常
					j = 1 / zero;
					break;
				case 1:
					int b[] = null;//空指针异常
					j = b[0];
					break;
				case 2:
					int c[] = new int[2];//数组下标越界异常
					j = c[3];
					break;
				case 3:
					char ch = "hello".charAt(9);//字符串下标越界异常
					break;
				case 4:
					char cha = "abc".charAt(1);
					System.out.println("abc的第2个字母是" + cha);
					break;
				}
				System.out.println("前面的语句都没有抛出异常才会运行我。");//正常语句
			} catch (ArithmeticException e) {
				System.out.println("捕获了数学方法异常！");
				e.printStackTrace();// 打印异常的栈信息
			} catch (NullPointerException e) {
				System.out.println("捕获了空指针异常！");
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("捕获了数组下标访问越界异常！");
				e.printStackTrace();
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("捕获了字符串下标越界异常！");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("第" + (i + 1) + "次捕获异常");
				System.out.println("显示的异常信息为：" + e);
				e.printStackTrace();
			} finally {
				System.out.println("不管异常抛出没抛出，捕获没捕获，我都一样运行。");
			}
		}
		
		test(10);// 正常
		test(-10);// 抛出小于0的异常
	}
	
}

//自定义一个小于0的异常
class BelowZeroException extends Exception {
	public BelowZeroException() {//空的构造方法
		
	}
	
	public BelowZeroException(String msg) {//自定义的异常类的构造方法，在有出错信息时创建异常对象
		super(msg);
	}
}
