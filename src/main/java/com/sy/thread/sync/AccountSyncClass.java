package com.sy.thread.sync;

public class AccountSyncClass implements Runnable{
	
	private static int i = 0;
	
	//同步方法是静态的，所以属于类的
	public static synchronized void increase(){
		i++;
	}
	@Override
	public void run() {
		for(int j= 0 ;j <10000000;j++){
			increase();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AccountSyncClass sy1 = new AccountSyncClass();
		AccountSyncClass sy2 = new AccountSyncClass();
		//虽然是两个对象，但属于同一个类，所以可以实现同步
		Thread t1 = new Thread(sy1,"t1");
		Thread t2 = new Thread(sy2,"t2");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("t1_name:"+t1.getName());
		System.out.println("t2_name:"+t2.getName());
		System.out.println(i);
	}

}
