package com.sy.pei.thread;

public class SynchronizedTest {
	public static void main(String[] args) {
		User user = new User("张三",100);
		
		Thread t1 = new MyThread("线程1", user, 20);
		Thread t2 = new MyThread("线程2", user, 10);
		Thread t3 = new MyThread("线程3", user, -10);
		Thread t4 = new MyThread("线程4", user, -2);
		Thread t5 = new MyThread("线程5", user, -40);
		Thread t6 = new MyThread("线程6", user, 15);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyThread extends Thread{
	private User u;
	private int x;
	
	public MyThread(String threadName,User u,int x){
		super(threadName);
		this.u = u;
		this.x=x;
	}
	@Override
	public void run() {
		u.oper(x);
	}
	
}

class User{
	private String name;
	private int cash;
	
	public User(String name,int cash){
		this.name = name;
		this.cash = cash;
	}
	
	public synchronized void oper(int x){
			this.cash += x;
			System.out.println(Thread.currentThread().getName() + " 当前账户是:" + name + ";此次操作剩余金额:" + cash);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
}