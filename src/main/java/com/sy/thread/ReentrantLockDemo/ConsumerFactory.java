package com.sy.thread.ReentrantLockDemo;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class ConsumerFactory extends Thread {
    private int number;
    private StoreInterface storeInterface;

    public ConsumerFactory(int number, StoreInterface storeInterface) {
        this.number = number;
        this.storeInterface = storeInterface;
    }

    public void consume(int number) {
        storeInterface.consume(number);
    }

    @Override
    public void run() {
        consume(number);
    }
}
