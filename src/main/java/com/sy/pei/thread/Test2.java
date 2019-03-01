package com.sy.pei.thread;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("main is start");
		sunThread();
		System.out.println("main is end");
	}
	public static void sunThread(){
		new Thread(){
			public void run() {
				try {
					System.out.println("sun thread is start");
					sleep(1000);
					System.out.println("sun thread is end");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();;
	}
}
