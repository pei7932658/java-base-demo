package com.sy.eventBus.eventListeners;

import com.google.common.eventbus.Subscribe;
import com.sy.eventBus.event.CustomEvent;

import java.time.Instant;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/12/20 13:40
 * @Modified By:
 */
public class EventListener1 {
    @Subscribe
    public void test3(CustomEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者1,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void test2(CustomEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者2,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
    }

    public void test4 (CustomEvent event ){
        System.out.println(Instant.now() + "监听者1-->订阅者4,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
    }
}
