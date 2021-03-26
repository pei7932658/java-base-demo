package com.sy.thread.ReentrantLockDemo;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 https://blog.csdn.net/qq_34587892/article/details/102977360
 */
public class ReentrantLockStore implements StoreInterface {

    private LinkedList linkList = new LinkedList();

    private static int MAX_VALUE = 100;

    private ReentrantLock fairReentrantLock = new ReentrantLock();//默认公平锁
    //    private ReentrantLock nonfairReentrantLock = new ReentrantLock(false);//创建不公平锁
    private Condition condition = fairReentrantLock.newCondition();


    @Override
    public void produce(int number) {
        fairReentrantLock.lock();
        try {
            while (linkList.size() + number > MAX_VALUE) {
                System.out.println("【要生产的产品数量】:" + number + "\t【库存量】:" + linkList.size() + "\t暂时不能执行生产任务!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fairReentrantLock.unlock();
        }

        for (int i = 0; i < number; i++) {
            linkList.add(new Object());
        }

        System.out.println("【已经生产产品数】:" + number + "\t【现仓储量为】:" + linkList.size());
        condition.signalAll();
    }

    @Override
    public void consume(int number) {
        fairReentrantLock.lock();
        try {
            while (linkList.size() < number) {
                System.out.println("【要消费的产品数量】:" + number + "\t【库存量】:" + linkList.size() + "\t暂时不能执行消费任务!");
                try {
                    condition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fairReentrantLock.unlock();
        }

        for (int i = 0; i < number; i++) {
            linkList.remove();
        }

        System.out.println("【已经消费产品数】:" + number + "\t【现仓储量为】:" + linkList.size());

        condition.signalAll();
    }
}
