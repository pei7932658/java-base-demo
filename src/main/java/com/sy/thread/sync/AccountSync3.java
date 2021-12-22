package com.sy.thread.sync;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class AccountSync3 implements Runnable {
    private static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            synchronized (AccountSync3.class) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AccountSync3 sy = new AccountSync3();
        AccountSync3 s2 = new AccountSync3();

        Thread t1 = new Thread(sy, "t1");
        Thread t2 = new Thread(s2, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("t1_name:"+t1.getName());
        System.out.println("t2_name:"+t2.getName());
        System.out.println(i);
    }
}
