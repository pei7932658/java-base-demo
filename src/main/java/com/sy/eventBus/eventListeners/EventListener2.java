package com.sy.eventBus.eventListeners;

import com.google.common.eventbus.Subscribe;
import com.sy.eventBus.event.CustomEvent;

import java.time.Instant;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/12/20 13:41
 * @Modified By:
 */
public class EventListener2 {
    @Subscribe
    public void test(CustomEvent event) {
        System.out.println(Instant.now() + ",监听者2,收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
