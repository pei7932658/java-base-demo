package com.sy.thread.sync;

public class AccountSync2 implements Runnable{
	
	private static int i = 0;
	
	//锁是加在对象上面的
	public synchronized void increase(){
		i++;
	}
	@Override
	public void run() {
		for(int j= 0 ;j <10000000;j++){
			increase();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AccountSync2 sy = new AccountSync2();
		//同一实现对象，同一个锁所以可以实现同步
		Thread t1 = new Thread(sy,"t1");
		Thread t2 = new Thread(sy,"t2");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("t1_name:"+t1.getName());
		System.out.println("t2_name:"+t2.getName());
		System.out.println(i);
	}

}
