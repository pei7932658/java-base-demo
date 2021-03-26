package com.sy.thread.dealTasksWithThread.demo1;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Slf4j
public class Math {
    private static final int MAX_THREAD_COUNT = 10;

    public static List<Long> getPrimeNumbers(Long start, Long end) {
        Long[] points = getPoints(start, end);

        List<Long> primeNumbers = new ArrayList<Long>();

        List<FutureTask<List<Long>>> futureTaskList = new ArrayList<FutureTask<List<Long>>>();
        ExecutorService excutorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
        for (int i = 0; i < points.length - 1; i++) {
            FutureTask<List<Long>> futureTask = new FutureTask<List<Long>>(new GetPrimeTask(points[i], points[i + 1] - 1));
            futureTaskList.add(futureTask);
            excutorService.submit(futureTask);
        }

        for (FutureTask<List<Long>> futureTask : futureTaskList) {
            try {
                List<Long> partPrimeNumbers = futureTask.get();
                primeNumbers.addAll(partPrimeNumbers);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return primeNumbers;
    }

    public static boolean isPrimeNumber(Long num) {
        for (Long i = 2L; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static Long[] getPoints(Long start, Long end) {
        Long[] points = new Long[MAX_THREAD_COUNT];

        for (int i = 0; i < MAX_THREAD_COUNT - 1; i++) {
            points[i] = start + (end - start) / (MAX_THREAD_COUNT - 1) * i;
        }
        points[MAX_THREAD_COUNT - 1] = end + 1;

        log.info("points:{}",points);
        return points;
    }
}