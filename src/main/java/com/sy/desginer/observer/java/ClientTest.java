package com.sy.desginer.observer.java;

/**
这个是用java.util 里面的Observable 类
 */
public class ClientTest {
    public static void main(String[] args) {
        OilFutures futures = new OilFutures();
        futures.addObserver(new Bull());
        futures.addObserver(new Bear());

        futures.setPrice(10);

        System.out.println(System.currentTimeMillis());
    }
}
