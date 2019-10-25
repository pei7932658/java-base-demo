package com.sy.distributedlock;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/7/23 13:27
 * @Modified By:
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}


