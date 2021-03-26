package com.sy.thread.futureTaskDemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
@Slf4j
public class Demo1 {
    public static void main(String[] args) {
        //taskWithCallable();
        //taskWithRunnable();
        taskWithCallableAndThreadPool();
    }

    private static void taskWithCallable() {
        // 第一步：声明具体的计算任务
        MyCallable callable = new MyCallable();
        //第二步：将任务传入初始化 FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //将futureTask交给一个线程去执行
        Thread thread = new Thread(futureTask);

        thread.setName("future task thread");
        thread.start();

        try {
            //Integer integer = futureTask.get();//阻塞队列，当任务没有完成时会去调用waitDone方法

            Integer integer = futureTask.get(1, TimeUnit.SECONDS); //等待1秒，如果任务未结束，会抛出异常，我们可以在异常里面对任务进行干预操作
            System.out.println("integer = " + integer);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();

            /***尝试取消任务，如果任务已经完成、已取消或其他原因无法取消，则失败。
             ** 1、如果任务还没开始执行，则该任务不应该运行
             **  2、如果任务已经开始执行，由参数mayInterruptIfRunning来决定执行该任务的线程是否应该被中断，这只是终止任务的一种尝试。若mayInterruptIfRunning为true，则会立即中断执行任务的线程并返回true，若mayInterruptIfRunning为false，则会返回true且不会中断任务执行线程。
             ** 3、调用这个方法后，以后对isDone方法调用都返回true。
             ** 4、如果这个方法返回true,以后对isCancelled返回true。
             ***/
            //futureTask.cancel(true);//中终任务
        }
        System.out.println(" task is over ");

    }

    private static void taskWithCallableAndThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //线程池通过submit开启线程
        Future<Integer> future = executorService.submit(new MyCallable());
        try {
            Thread.sleep(1000);

            log.info("do something in main");

            //在Callable中的方法运行完之前 这里会一直阻塞，直到Callable运行完
            //然后就可以从future里获取到结果了
            Integer result = future.get();
            log.info("result: {}", result);
            executorService.shutdown();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void taskWithRunnable() {
        // 第一步：声明具体的计算任务
        MyRunnable runnable = new MyRunnable();
        Integer result = 0;
        //第二步：将任务传入到futureTask
        FutureTask<Integer> futureTask = new FutureTask(runnable, result);//无法获取到返回值

        Thread thread = new Thread(futureTask);
        thread.setName("future task thread");
        thread.start();
        System.out.println("result = " + result);

        try {
            Integer integer = futureTask.get();//阻塞队列，当任务没有完成时会去调用waitDone方法

            //Integer integer = futureTask.get(1, TimeUnit.SECONDS); //等待1秒，如果任务未结束，会抛出异常，我们可以在异常里面对任务进行干预操作
            System.out.println("integer = " + integer);
            System.out.println("after get result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

            /***尝试取消任务，如果任务已经完成、已取消或其他原因无法取消，则失败。
             ** 1、如果任务还没开始执行，则该任务不应该运行
             **  2、如果任务已经开始执行，由参数mayInterruptIfRunning来决定执行该任务的线程是否应该被中断，这只是终止任务的一种尝试。若mayInterruptIfRunning为true，则会立即中断执行任务的线程并返回true，若mayInterruptIfRunning为false，则会返回true且不会中断任务执行线程。
             ** 3、调用这个方法后，以后对isDone方法调用都返回true。
             ** 4、如果这个方法返回true,以后对isCancelled返回true。
             ***/
            //futureTask.cancel(true);//中终任务
        }
        System.out.println(" task is over ");
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        int total = 0;
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(" thread: " + Thread.currentThread().getName() + " i = " + i);
                Thread.sleep(200);
                total += i;
            }
        } catch (InterruptedException e) {
            System.out.println("task is interrupted");
            // 遇到异常需要中断后返回以保证结束线程
            return 0;
        }
        return total;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        int total = 0;
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(" thread: " + Thread.currentThread().getName() + " i = " + i);
                Thread.sleep(200);
                total += i;
            }
        } catch (InterruptedException e) {
            System.out.println("task is interrupted");
        }
        System.out.println("线程内部执行完成：total=" + total);
    }
}
