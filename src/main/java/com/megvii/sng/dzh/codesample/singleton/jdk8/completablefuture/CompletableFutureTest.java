package com.megvii.sng.dzh.codesample.singleton.jdk8.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author:peiliang
 * @Description: CompletableFuture 用法
 * 参考网址：https://www.cnblogs.com/fingerboy/p/9948736.html
 * @Date:2019/5/23 14:17
 * @Modified By:
 */
public class CompletableFutureTest {

    /**
     * 创建任务runAsync：无参数传入
     * Async结尾的方法都是可以异步执行的，如果指定了线程池，会在指定的线程池中执行，如果没有指定，默认会在ForkJoinPool.commonPool()中执行
     */
    public static void runAsyncTest() {
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

        System.out.println("主线程名称：" + Thread.currentThread().getName() + " : 完成");

        try {
            //主线程不断，让打印子线程日志
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建任务supplyAsync:有参数传入
     */
    public static void thenSupplyAsyncTest() {
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

    /**
     * thenAccept
     * 当上一个任务正常执行完成，会把参数传入下面一个CompletionStage，无返回结果
     */
    public static void thenAcceptTest() {
        System.out.println("主线程名称：" + Thread.currentThread().getName());
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("执行异步操作1 开始,线程名称:" + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello";
        }).thenAccept(v -> {
            System.out.println("执行异步操作2 开始,线程名称:" + Thread.currentThread().getName());
            System.out.println(v + " world");
        }).join();

        System.out.println("thenAccept 无返回结果");
    }

    /**
     * thenApply
     * 当上一个任务正常执行完成，会把参数传入下面一个CompletionStage，有返回结果
     */
    public static void thenApplyTest() {
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
            System.out.println("执行异步操作2 开始,线程名称:" + Thread.currentThread().getName());
            return v + " world";
        }).join();

        System.out.println("返回结果:" + result);
    }

    /**
     * thenRun
     * 不关心上一步的计算结果，执行下一个操作，无返回结果
     */
    public static void thenRunTest() {
        System.out.println("主线程名称：" + Thread.currentThread().getName());
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("执行异步操作1 开始,线程名称:" + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).thenRunAsync(() -> {
            System.out.println("执行异步操作2 开始,线程名称:" + Thread.currentThread().getName());
        }).join();

        System.out.println("thenRunAsync 不需要参数，也无返回结果");
    }


    /**
     * thenCombine
     * 两个CompletionStage的结果,然后转化返回
     * 需要根据商品id查询商品的当前价格,分两步,查询商品的原始价格和折扣,这两个查询相互独立,当都查出来的时候用原始价格乘折扣,算出当前价格. 使用方法:thenCombine(..)
     */
    public static void thenCombineTest() {
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> 100d);

        CompletableFuture<Double> futureDiscount = CompletableFuture.supplyAsync(() -> 0.88d);

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
        futurePrice.runAfterBoth(futureDiscount, () -> {
            System.out.println("等A和B都执行完，才会执行本线程");
        });
    }

    /**
     * applyToEither
     * A和B 哪个先返回用哪一个
     * 假设查询商品a,有两种方式,A和B,但是A和B的执行速度不一样,我们希望哪个先返回就用那个的返回值
     */
    public static void applyToEitherTest() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "获取A的信息";
        });

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "获取B的信息";
        });

        //applyToEither的兄弟方法还有acceptEither(),runAfterEither(),我想不需要我解释你也知道该怎么用了
        CompletableFuture<String> result = futureA.applyToEither(futureB, product -> "结果:" + product);
        System.out.println(result.join());
    }

    /**
     * thenCompose
     * 输入是当前的CompletableFuture的计算值，返回结果将是一个新的CompletableFuture
     * 类似于thenApply的用法
     * thenCompose 和thenApply 除了返回值展现形式不一样，有什么区别呢？？
     */
    private static void thenComposeTest() {
//        thenApply():它的功能相当于将CompletableFuture<T>转换成CompletableFuture<U>,改变的是同一个CompletableFuture中的泛型类型
//　　    thenCompose():用来连接两个CompletableFuture，返回值是一个新的CompletableFuture

        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "futureA 返回值.");

        CompletableFuture<String> newFuture = futureA.thenComposeAsync(aResult -> {
            return CompletableFuture.supplyAsync(() -> "thenCompose返回值,返回的是CompletionStage,收到futureA的传入参数:" + aResult);
        });

        System.out.println(newFuture.join());
    }

    /**
     * 当运行出现异常时,调用该方法可进行一些补偿操作,如设置默认值
     */
    public static void exceptionallyTest() {

        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "100/0的结果:" + (100 / 0))
                .exceptionally(e -> {
                    System.out.println(e.getMessage());
                    return "futureA返回要默认值:" + 100;
                });

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "100/2的结果:" + (100 / 2))
                .exceptionally(e -> {
                    System.out.println(e.getMessage());
                    return "futureB返回要默认值:" + 100;
                });

        System.out.println(futureA.join());

        System.out.println(futureB.join());

    }

    /**
     * whenComplete
     * 执行顺序:supplyAsync->whenComplete->exceptionally
     * 当supplyAsync有异常时,thenApply不执行 但 whenComplete 都会执行
     * whenComplete 没有返回值
     */
    public static void whenCompleteTest1() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "futureA 返回结果:" + (100 / 0))
                .thenApply(s -> "apply results:" + s)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println("whenComplete:" + s);//未执行
                    }
                    if (e != null) {
                        System.out.println("whenComplete:" + e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                })
                .exceptionally(e -> {
                    System.out.println("exceptionally:" + e.getMessage());
                    return "futureB返回要默认值:" + 100;
                });

        System.out.println(futureA.join());
    }

    /**
     * 把执行顺序换一下：supplyAsync->exceptionally->whenComplete
     * 先执行了exceptionally后执行whenComplete,可以发现,由于在exceptionally中对异常进行了处理,并返回了默认值,whenComplete中接收到的结果是一个正常的结果,被exceptionally美化过的结果,这一点需要留意一下.
     */
    public static void whenCompleteTest2() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "futureA 返回结果:" + (100 / 0))
                .thenApply(s -> "apply results:" + s)
                .exceptionally(e -> {
                    System.out.println("exceptionally:" + e.getMessage());
                    return "futureB返回要默认值:" + 100;
                })
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println("whenComplete:" + s);//未执行
                    }
                    if (e != null) {
                        System.out.println("whenComplete:" + e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                });


        System.out.println(futureA.join());
    }

    /**
     * handle
     * 当CompletableFuture的计算结果完成，或者抛出异常的时候，可以通过handle方法对结果进行处理
     */
    public static void handleTest() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "futureA 返回结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println("handle:" + s);//未执行
                    } else {
                        System.out.println("handle:" + e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                    return "handle result:" + (s == null ? "500" : s);
                })
                .exceptionally(e -> {
                    System.out.println("exceptionally:" + e.getMessage()); //未执行
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());
    }

    /**
     * 换一下handle和exceptionally执行顺序
     */
    public static void handleTest2() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "futureA 返回结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .exceptionally(e -> {
                    System.out.println("exceptionally:" + e.getMessage()); //未执行
                    return "futureA result: 100";
                })
                .handle((s, e) -> {
                    if (e == null) {
                        System.out.println("handle:" + s);//未执行
                    } else {
                        System.out.println("handle:" + e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                    return "handle result:" + (s == null ? "500" : s);
                });
        System.out.println(futureA.join());
    }

    /**
     * 1.handle 有返回值,whenComplete 无返回值
     * 2.handle 有返回值，所以可以替换exceptionally,处理异常，并且给出默认值
     */
    public static void handleAndwhenCompleteDiff() {

    }

    /**
     * allOf:当所有的CompletableFuture都执行完后执行计算
     * anyOf:最快的那个CompletableFuture执行完之后执行计算
     */
    public static void allOfAndanyOfTest() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "futureA";
        });

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "futureB";
        });

        CompletableFuture of = CompletableFuture.anyOf(futureA, futureB);
//        CompletableFuture of = CompletableFuture.allOf(futureA,futureB);

        of.join();

        System.out.println(futureA.join());
        System.out.println(futureB.join());

        System.out.println("main end");
    }

    public static void main(String[] args) {
        allOfAndanyOfTest();
    }

}
