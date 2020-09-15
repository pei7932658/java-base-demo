package com.sy.thread;

public class VisibilityTest extends Thread{
	private volatile boolean stop;
	private int i = 0;
	@Override
	public void run() {
		while(!stop){
			i++;
		}
		System.out.println("i:"+i);
	}
	
	public void stopIt(){
		stop = true;
	}
	
	public boolean getStop(){
		return stop;
	}

	//相当于算出CPU一秒内，可以做多少次+法
	public static void main(String[] args) throws InterruptedException {
		VisibilityTest test = new VisibilityTest();
		test.start();
		
		Thread.sleep(1000);
		test.stopIt();
		
		System.out.println("finish :"+test.getStop());
	}

}
