package com.megvii.sng.dzh.codesample.singleton.jdk8.completablefuture;

import java.util.concurrent.*;

/**
 * @Author:peiliang
 * @Description:
 * CompletableFuture 用法
 * 参考网址：https://www.cnblogs.com/fingerboy/p/9948736.html
 * @Date:2019/5/23 14:17
 * @Modified By:
 */
public class CompletableFutureTest {

    /**
     * Async结尾的方法都是可以异步执行的，如果指定了线程池，会在指定的线程池中执行，如果没有指定，默认会在ForkJoinPool.commonPool()中执行
     */
    public static void runAsync_Test() {
        System.out.println("主线程名称：" + Thread.currentThread().getName());

        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println("执行异步操作开始,线程名称:" + Thread.currentThread().getName());

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println("执行异步操作结束,线程名称:" + Thread.currentThread().getName());

        });

        // 无返回值为null String result = (String) future.get();

        //执行任务A,任务A执行完以后,执行任务B,任务B不接受任务A的返回值(不管A有没有返回值,这里用的是runAsync无返回值),也无返回值
//        future.thenRun(() -> {
//            System.out.println("执行异步操作开始,线程名称:" + Thread.currentThread().getName());
//        });

        //thenRunAsync 表示另启一个线程
        future.thenRunAsync(() -> {
            System.out.println("执行异步操作开始,线程名称:" + Thread.currentThread().getName());
        });

        System.out.println("主线程名称：" + Thread.currentThread().getName() + " : 完成");

        try {
            //主线程不断，让打印子线程日志
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //变化结果有返回值
    public static void thenSupplyAsync_Test() {
        System.out.println("主线程名称：" + Thread.currentThread().getName());

        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("执行异步操作1 开始,线程名称:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello";
        });

        /**
         * get()会堵塞当前的线程,这就造成了一个问题,如果执行线程迟迟没有返回数据,get()会一直等待下去
         */
//        try {
//            String result = (String) future.get();
//            System.out.println("返回结果:" + result);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        /**
         * get设置时间，如果超时，就抛TimeoutException异常出来
         */
//        try {
//            String result = (String) future.get(1, TimeUnit.SECONDS);
//            System.out.println("返回结果:" + result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            System.out.println("获取返回结果超时");
//        }


        /**
         * getNow 立马返回结果,如果子线程还没有返回，就返回默认值，这个方法可以用于查询子线程完成情况使用
         */
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(future.getNow("defaultValue"));


        /**
         * join 把子线程加入当前线程
         */
//        future.join();

        /**
         * thenRun 等A线程执行完，再B，A可以有参数，可以无，但thenRun 不接收参数,也无返回值
         */
        future.thenRun(() -> {
            System.out.println("执行异步操作开始,线程名称:" + Thread.currentThread().getName());
        });

        System.out.println("main end");
    }

    //变化结果有返回值
    public static void thenApply_Test() {
        System.out.println("主线程名称：" + Thread.currentThread().getName());
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("执行异步操作1 开始,线程名称:" + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello";
        }).thenApplyAsync(v -> {
            System.out.println("执行异步操作2 开始,线程名称:" + Thread.currentThread().getName()); //发现实际是一个线程
            return v + " world";
        }).join();

        System.out.println("返回结果:" + result);
    }

    /**
     * 指定线程池运行线程
     */
    public static void sync() {
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

    /**
     * 需要根据商品id查询商品的当前价格,分两步,查询商品的原始价格和折扣,这两个查询相互独立,当都查出来的时候用原始价格乘折扣,算出当前价格. 使用方法:thenCombine(..)
     */
    public static void thenCombineTest(){
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(()->100d);

        CompletableFuture<Double> futureDiscount  = CompletableFuture.supplyAsync(()->0.88d);

        //thenCombine 有返回值
//        CompletableFuture<Double> futureResult = futurePrice.thenCombine(futureDiscount,(price,discount)->{
//            return price*discount;
//        });
//        System.out.println(futureResult.join());


        //thenAcceptBoth 无返回值
//        futurePrice.thenAcceptBoth(futureDiscount,(price,discount)->{
//            System.out.println(price*discount);
//        });
//        futurePrice.join();

        //A 和B 有没有返回值不关心
        futurePrice.runAfterBoth(futureDiscount,()->{
            System.out.println("等A和B都执行完，才会执行本线程");
        });
    }

    /**
     * 假设查询商品a,有两种方式,A和B,但是A和B的执行速度不一样,我们希望哪个先返回就用那个的返回值
     */
    public static void applyToEitherTest(){
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "获取A的信息";
        });

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "获取B的信息";
        });

        //applyToEither的兄弟方法还有acceptEither(),runAfterEither(),我想不需要我解释你也知道该怎么用了
        CompletableFuture<String> result = futureA.applyToEither(futureB,product->"结果:"+product);
        System.out.println(result.join());
    }

    public static void main(String[] args) {
        applyToEitherTest();
    }

}
