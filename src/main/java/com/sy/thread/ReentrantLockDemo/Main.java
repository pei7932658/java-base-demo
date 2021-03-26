package com.sy.thread.ReentrantLockDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ReentrantLockStore reentrantLockStore = new ReentrantLockStore();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new ProduceFactory(5, reentrantLockStore));
        }

        for (int i = 0; i < 10; i++) {
            executorService.submit(new ConsumerFactory(3, reentrantLockStore));
        }
    }
}
