package com.sy.pei.thread;

public class JoinTest {
	public static void main(String[] args) {
		Thread thread1 = new MyThread1();
			thread1.start();
		for (int i = 0; i < 20; i++) {
			System.out.println("主线程第"+i+"执行");
			if(i>2)
				try {
					//thread1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。 
					thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

class MyThread1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("分线程1第"+i+"执行");
		}
	}
	
}