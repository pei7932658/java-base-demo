package com.sy.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/5/31 11:27
 * @Modified By:
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {

    }

    /**
     * 指定线程池运行线程
     */
    public static void syncWithExecutorService() {
        //当这里线程池只有2个线程时，下面，如果起多个线程，只能排队
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture.runAsync(() -> {
            System.out.println("开启子线程1 :" + Thread.currentThread().getName());

            try {
                //主线程不断，让打印子线程日志
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, executorService);

        CompletableFuture.runAsync(() -> {
            System.out.println("开启子线程2 :" + Thread.currentThread().getName());

            try {
                //主线程不断，让打印子线程日志
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, executorService);

        CompletableFuture.runAsync(() -> {
            System.out.println("开启子线程3 :" + Thread.currentThread().getName());

            try {
                //主线程不断，让打印子线程日志
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, executorService);

        executorService.shutdown();


        System.out.println("主线程: " + Thread.currentThread().getName());
        try {
            //主线程不断，让打印子线程日志
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
