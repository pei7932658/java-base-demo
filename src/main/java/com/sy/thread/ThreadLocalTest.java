package com.sy.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * ThreadLocal是什么：
 * 1、ThreadLocal中填充的变量属于当前线程，该变量对其他线程而言是隔离的。
 * 2、ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量
 * <p>
 * ThreadLocal使用：
 * 1、在进行对象跨层传递的时候，使用ThreadLocal可以避免多次传递，打破层次间的约束。
 * 2、线程间数据隔离
 * 3、进行事务操作，用于存储线程事务信息。
 * 4、数据库连接，Session会话管理。
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        //新建一个ThreadLocal
        ThreadLocal<String> local = new ThreadLocal<>();

        Random random = new Random();

        //java8IntStream 新建5个线程
        IntStream.range(0, 5).forEach(r -> {
            new Thread(() -> {
                local.set(r + " " + random.nextInt(10));
                //每个线程输出的local值都不一样，说明是线程局部变量
                System.out.println("线程和local的值分别是: " + local.get());

                //睡1秒，让其它线程有时间读取自己的local变量
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        });
    }
}
