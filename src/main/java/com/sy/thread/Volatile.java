package com.sy.thread;

import java.util.concurrent.atomic.AtomicLong;

public class Volatile {
	
	private static volatile AtomicLong  _longVal = new AtomicLong(0);

	private static class LoopVolatile implements Runnable {
		public void run() {
			long val = 0;
			while (val < 10000000L) {
				_longVal.addAndGet(1);
				val++;
			}
		}
	}

	private static class LoopVolatile2 implements Runnable {
		public void run() {
			long val = 0;
			while (val < 10000000L) {
				_longVal.addAndGet(1);
				val++;
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new LoopVolatile());
		t1.start();

		Thread t2 = new Thread(new LoopVolatile2());
		t2.start();

		while (t1.isAlive() || t2.isAlive()) {
			
		}

		System.out.println("final val is: " + _longVal);
	}
}
