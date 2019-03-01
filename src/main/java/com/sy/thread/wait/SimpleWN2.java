package com.sy.thread.wait;

public class SimpleWN2 {
	final static Object object = new Object();
	public static class T1 extends Thread{
		@Override
		public void run() {
			synchronized(object){
				System.out.println("t1 start ! wait on object");
				try {
					object.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1 end !");
			}
		}
	}
	public static class T2 extends Thread{
		@Override
		public void run() {
			synchronized(object){
				System.out.println("t2 start ! wait on object");
				try {
					object.notifyAll();
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 end !");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		T1 t1 = new T1();
		T1 t1_1 = new T1();
		t1.start();
		t1_1.start();
		Thread.sleep(1000);
		T2 t2 = new T2();
		t2.start();
		t2.join();
		Thread.sleep(4000);
		System.out.println(t1.getState().toString());
		System.out.println(t1_1.getState().toString());
	}
}
