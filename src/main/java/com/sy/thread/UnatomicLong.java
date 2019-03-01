package com.sy.thread;

import ch.qos.logback.core.net.SyslogOutputStream;

public class UnatomicLong implements Runnable {
	private static long test = 0;

	private final long val;

	public UnatomicLong(long val) {
		this.val = val;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			test = val;
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new UnatomicLong(-1));
		Thread t2 = new Thread(new UnatomicLong(0));

		t1.start();
		t2.start();
		long val;
		while ((val = test) == -1 || val == 0) {
			// 如果静态成员test的值是-1或0，说明两个线程操作没有交叉
			System.out.println("ccc");
		}

		System.out.println(pad(Long.toBinaryString(val), 64));
		System.out.println(val);

		t1.interrupt();
		t2.interrupt();

	}

	private static String pad(String s, int targetLength) {
		int n = targetLength - s.length();
		for (int x = 0; x < n; x++) {
			s = "0" + s;
		}
		return s;
	}
}
