package com.sy.thread.dealTasksWithThread.demo1;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 本文通过一个获取某个区间内质数的例子来说明如何使用java进行多线程并发处理。
 * <p>
 * Java多线程处理任务等待任务全部执行
 * https://blog.csdn.net/baozhutang/article/details/103626712
 * 1.使用CountDownLatch
 * 2.使用CyclicBarrier
 * 3.CompletionService
 * 4.使用CompletableFuture
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        testCountDownLatch();
    }

    private static void testCompleableFuture() {
        //System.out.println("start");
        Long startTime = getCurTime();
        log.info("startTime:{}", startTime);
        List<Long> primeNumberList = Math.getPrimeNumbers(200000L, 300000L);

        for (Long primeNumber : primeNumberList) {
            System.out.println("" + primeNumber);
        }
        Long endTime = getCurTime();

        System.out.println("消耗时间:" + (endTime - startTime) + " ms");
    }

    private static Long getCurTime() {
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }

    private static void testCountDownLatch() {
        //模拟要处理的10个任务
        List<Object> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            jobs.add(new Object());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 + 1);
        log.info("开始本次批量处理，数据个数{},时间,{}", jobs.size(), LocalDateTime.now());
        CountDownLatch countDownLatch = new CountDownLatch(jobs.size());
        int result = 0;
        jobs.forEach(j -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    log.info("当前线程休眠完成");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    log.error("异常", e);
                }
            });
        });

        try {
            //countDownLatch.await();
            countDownLatch.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("完成本次批量处理，数据个数：{}，时间：{}", jobs.size(), LocalDateTime.now());
        executorService.shutdown();
    }


}
