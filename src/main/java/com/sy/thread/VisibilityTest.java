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
	
	public static void main(String[] args) throws InterruptedException {
		VisibilityTest test = new VisibilityTest();
		test.start();
		
		Thread.sleep(1000);
		test.stopIt();
		
		System.out.println("finish :"+test.getStop());
	}

}
