package com.bisn.basic;

/*
 * 多核CPU、多线程、多进程
 * 线程是小一号的进程，也被称为是轻量级进程。线程可以共享数据也可以不共享数据，但进程不能共享数据空间。
 * 线程是生活在进程内部的，是可以并发执行的多个函数。线程要注意数据并发的问题，线程的共享数据指的是堆空间的共享（堆空间存放的是对象），而栈空间是独立的，不能被共享。
 * 线程组成的三要素是：CPU、data和code。
 * 线程的生命周期有4中状态：new（新建状态）、Runnable（可运行状态）、Blocked（阻塞状态）、Dead（死亡状态）。
 * 可运行状态包括准备状态和运行状态。
 * 
 * 线程的创建有两种方式：一是继承Thread类来创建对象，二是声明实现了Runnable接口的类。
 * 
 */

public class ThreadTest {

	public static void main(String[] args) {
		//用类MyThread创建两个线程对象，并启动
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		t1.start();
		t2.start();
		
		Thread tt1 = new MyThread();
		Thread tt2 = new Thread(new MyRunnable());
		tt1.setName("Thread-01");
		tt2.setName("Thread-02");
		tt1.setPriority(5);
		tt2.setPriority(5);
		tt2.setDaemon(true);
		tt1.start();
		tt2.start();
	}
}

//定义MyThread类，继承自Thread类
class MyThread extends Thread {
	private int i = 0;
	
	public void run() {
		for (; i < 20; i++) {
			System.out.println(getName() + ":i = " + i);//输出0~19的数字
			try {
				Thread.sleep(200);//线程睡眠200毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//类MyRunnable实现了Runnable接口
class MyRunnable implements Runnable {
	//重写run方法
	public void run() {
		char c = 'A';
		while (c < 'Z') {//用while循环输出
			System.out.println(Thread.currentThread().getName() + ":II = " + c);
			c++;
			for (int j = 0; j < 1000; j++) {//延迟
				;
			}
		}
	}
}
