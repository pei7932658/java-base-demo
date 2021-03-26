package com.sy.thread.ReentrantLockDemo;

public interface StoreInterface {
    void produce(int number);

    void consume(int number);
}
