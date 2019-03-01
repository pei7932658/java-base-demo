package com.sy.thread.sync;

public class AccountSyncBad implements Runnable{
	
	private static int i = 0;
	
	//该方法属于类实例对象的
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
		AccountSyncBad sy1 = new AccountSyncBad();
		AccountSyncBad sy2 = new AccountSyncBad();
		//两个线程，不同实例，所以操作肯定不能同步
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
