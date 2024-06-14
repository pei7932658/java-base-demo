package com.sy.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2022/6/9 14:35
 * @Modified By:
 * @Version: 1.0
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        " 开始 threadId = "
                                + Thread.currentThread().getId()
                                + ",,,threadName = " + Thread.currentThread().getName()
                                + ",,,时间" +  formatDateToString(new Date())
                );

                try {
                    Thread.sleep(1000);
                    System.out.println(
                            " 结束 threadId = "
                                    + Thread.currentThread().getId()
                                    + ",,,threadName = " + Thread.currentThread().getName()
                                    + ",,,时间" + formatDateToString(new Date())
                    );

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 5, 5, TimeUnit.SECONDS);


        scheduler.scheduleAtFixedRate(() -> {
            System.out.println(
                    " 开始 threadId = "
                            + Thread.currentThread().getId()
                            + ",,,threadName = " + Thread.currentThread().getName()
                            + ",,,时间" +  formatDateToString(new Date())
            );

            try {
                Thread.sleep(1000);
                System.out.println(
                        " 结束 threadId = "
                                + Thread.currentThread().getId()
                                + ",,,threadName = " + Thread.currentThread().getName()
                                + ",,,时间" + formatDateToString(new Date())
                );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

        public static String formatDateToString(Date time) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(time);
        }

    public static void test(){
        System.out.println("test");
    }

}


