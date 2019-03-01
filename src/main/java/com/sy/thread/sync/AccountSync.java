package com.sy.thread.sync;

public class AccountSync implements Runnable{
	private  AccountSync sync = new AccountSync();
	private static int i = 0;
	@Override
	public void run() {
		synchronized(sync){
			for(int j= 0 ;j <100000;j++){
				i++;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		AccountSync sy = new AccountSync();
		Thread t1 = new Thread(sy);
		Thread t2 = new Thread(sy);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
	}

}
