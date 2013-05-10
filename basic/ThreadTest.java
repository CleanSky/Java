package com.bisn.basic;

/*
 * ���CPU�����̡߳������
 * �߳���Сһ�ŵĽ��̣�Ҳ����Ϊ�����������̡��߳̿��Թ�������Ҳ���Բ��������ݣ������̲��ܹ������ݿռ䡣
 * �߳��������ڽ����ڲ��ģ��ǿ��Բ���ִ�еĶ���������߳�Ҫע�����ݲ��������⣬�̵߳Ĺ�������ָ���Ƕѿռ�Ĺ����ѿռ��ŵ��Ƕ��󣩣���ջ�ռ��Ƕ����ģ����ܱ�����
 * �߳���ɵ���Ҫ���ǣ�CPU��data��code��
 * �̵߳�����������4��״̬��new���½�״̬����Runnable��������״̬����Blocked������״̬����Dead������״̬����
 * ������״̬����׼��״̬������״̬��
 * 
 * �̵߳Ĵ��������ַ�ʽ��һ�Ǽ̳�Thread�����������󣬶�������ʵ����Runnable�ӿڵ��ࡣ
 * 
 */

public class ThreadTest {

	public static void main(String[] args) {
		//����MyThread���������̶߳��󣬲�����
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

//����MyThread�࣬�̳���Thread��
class MyThread extends Thread {
	private int i = 0;
	
	public void run() {
		for (; i < 20; i++) {
			System.out.println(getName() + ":i = " + i);//���0~19������
			try {
				Thread.sleep(200);//�߳�˯��200����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//��MyRunnableʵ����Runnable�ӿ�
class MyRunnable implements Runnable {
	//��дrun����
	public void run() {
		char c = 'A';
		while (c < 'Z') {//��whileѭ�����
			System.out.println(Thread.currentThread().getName() + ":II = " + c);
			c++;
			for (int j = 0; j < 1000; j++) {//�ӳ�
				;
			}
		}
	}
}
