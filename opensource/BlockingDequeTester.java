package com.bisn.opensource;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * 基于 java.util.BlockingQueue 实现的生产者和消费者算法
 * 
 * BlockingDeque 方法有四种形式，使用不同的方式处理无法立即满足但在将来某一时刻可能满足的操作
 * 第一种方式抛出异常；
 * 第二种返回一个特殊值（null 或 false，具体取决于操作）；
 * 第三种无限期阻塞当前线程，直至操作成功；
 * 第四种只阻塞给定的最大时间，然后放弃。
 */

public class BlockingDequeTester {
	public static void main(String[] args) {
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>(5);
		Runnable producer = new Producer("Producer", deque);
		Runnable consumer = new Consumer("Consumer", deque);
		new Thread(producer).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(consumer).start();
	}
}

// 生产者
class Producer implements Runnable {
	private String name;
	private BlockingDeque<Integer> deque;

	public Producer(String name, BlockingDeque<Integer> deque) {
		this.name = name;
		this.deque = deque;
	}

	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			try {
				deque.putFirst(i);
				System.out.println(name + " puts " + i);
				Thread.sleep(300);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//消费者
class Consumer implements Runnable {
	private String name;
	private BlockingDeque<Integer> deque;

	public Consumer(String name, BlockingDeque<Integer> deque) {
		this.name = name;
		this.deque = deque;
	}

	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			try {
				int j = deque.takeLast();
				System.out.println(name + " takes " + j);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
