package com.sy.thread.dealTasksWithThread.demo1;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.List;

/**
 本文通过一个获取某个区间内质数的例子来说明如何使用java进行多线程并发处理。

 Java多线程处理任务等待任务全部执行
 https://blog.csdn.net/baozhutang/article/details/103626712
 1.使用CountDownLatch
 2.使用CyclicBarrier
 3.CompletionService
 4.使用CompletableFuture
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        //System.out.println("start");
        Long startTime = getCurTime();
        log.info("startTime:{}",startTime);
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
}
