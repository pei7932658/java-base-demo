package com.sy.distributedlock;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/7/23 13:27
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}