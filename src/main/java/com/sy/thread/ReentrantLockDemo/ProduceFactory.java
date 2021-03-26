package com.sy.thread.ReentrantLockDemo;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class ProduceFactory extends Thread {

    private int number;
    private StoreInterface storeInterface;

    public ProduceFactory(int number, StoreInterface storeInterface) {
        this.number = number;
        this.storeInterface = storeInterface;
    }

    private void produce(int number) {
        storeInterface.produce(number);
    }

    @Override
    public void run() {
        produce(number);
    }
}
