package com.sy.thread;

public class Test1 extends Thread{
	
	private String name;
	
	public Test1(String name){
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("thread name is :"+name);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test1 t1 = new Test1("t1");
		Test1 t2 = new Test1("t2");
		Test1 t3 = new Test1("t3");
		
		t1.run();;t1.join();
		t2.start();t2.join();
		t3.start();
		
	}

	

}
