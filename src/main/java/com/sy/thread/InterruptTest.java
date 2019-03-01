package com.sy.thread;

public class InterruptTest implements Runnable{

	@Override
	public void run() {
		while(true){
			if(Thread.currentThread().isInterrupted()){
				System.out.println("i was isterrupted so stop");
				break;
			}
			try {
				Thread.sleep(1000);
				System.out.println("working");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		InterruptTest t1 = new InterruptTest();
			
		try {
			Thread t = new Thread(t1);
			t.start();
			Thread.sleep(3000);
			t.interrupt();
			System.out.println("stoped");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
