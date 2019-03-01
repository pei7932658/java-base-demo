package com.sy.pei.thread;

public class DaemonTest {
	public static void main(String[] args) {
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon());
			t2.setDaemon(true);//设置为守护线程，当该线程结束的时候，也结束其它线程
		Thread t3 = new Thread(new MyCommon3());
			t3.setDaemon(false);//守护线程默认只设置一个有效
		t2.start();
		t3.start();
		t1.start();
	}
}

class MyCommon  extends Thread{

	@Override
	public void run() {
		 for (int i = 0; i < 5; i++) {
             System.out.println("线程1第" + i + "次执行！");
             try {
                     Thread.sleep(7);
             } catch (InterruptedException e) {
                     e.printStackTrace();
             }
		 } 
	}
	
}
class MyCommon3  extends Thread{

	@Override
	public void run() {
		 for (int i = 0; i < 5; i++) {
             System.out.println("线程3第" + i + "次执行！");
             try {
                     Thread.sleep(7);
             } catch (InterruptedException e) {
                     e.printStackTrace();
             }
		 } 
	}
	
}
class MyDaemon  implements Runnable {
	public void run() {
		  for (long i = 0; i < 9999999L; i++) {
              System.out.println("后台线程第" + i + "次执行！");
              try {
                      Thread.sleep(7);
              } catch (InterruptedException e) {
                      e.printStackTrace();
              }
      } 
	}
}