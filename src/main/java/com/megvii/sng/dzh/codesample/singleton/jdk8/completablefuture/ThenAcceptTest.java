package com.megvii.sng.dzh.codesample.singleton.jdk8.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/5/31 11:27
 * @Modified By:
 */
public class ThenAcceptTest {
    public static void main(String[] args) {

    }

    public static void thenAcceptTest() {
        System.out.println("主线程名称：" + Thread.currentThread().getName());

        CompletableFuture.runAsync(() -> {
            System.out.println("执行异步操作开始,线程名称:" + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("执行异步操作结束,线程名称:" + Thread.currentThread().getName());

        });
        System.out.println("主线程名称：" + Thread.currentThread().getName() + " : 完成");

        try {
            //主线程不断，让打印子线程日志
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
