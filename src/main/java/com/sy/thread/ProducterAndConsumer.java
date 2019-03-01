package com.sy.thread;

public class ProducterAndConsumer {
	
	private int box = 0;
	
	public synchronized void add() throws InterruptedException {
		System.out.println("===添加元素===");
		Thread.sleep(1000);
		if (box >= 10) {
			wait();
		}
		box++;
		notify();
		System.out.println("添加元素之后，box num :" + box);
	}
	
	public synchronized void get() throws InterruptedException {
		System.out.println("===删除元素===");
		Thread.sleep(1000);
		if (box <= 0) {
			wait();
		}
		box--;
		notify();
		System.out.println("删除元素之后，box num :" + box);

	}
	
	static class P implements Runnable{
		private ProducterAndConsumer pc;
		
		public P(ProducterAndConsumer pc){
			this.pc = pc;
		}
		@Override
		public void run() {
			while(true){
				try {
					pc.add();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	static class C implements Runnable{
		private ProducterAndConsumer pc;
		
		public C(ProducterAndConsumer pc){
			this.pc = pc;
		}
		@Override
		public void run() {
			while(true){
				try {
					pc.get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		ProducterAndConsumer pc = new ProducterAndConsumer();
		new Thread(new P(pc)).start();
		new Thread(new P(pc)).start();
		new Thread(new C(pc)).start();
	}

}
