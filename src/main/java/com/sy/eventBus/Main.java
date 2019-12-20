package com.sy.eventBus;

import com.sy.eventBus.event.CustomEvent;
import com.sy.eventBus.eventListeners.EventListener1;
import com.sy.eventBus.eventListeners.EventListener2;
import com.sy.eventBus.util.EventBusUtil;

import java.time.Instant;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/12/20 13:49
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {

        EventListener1 listener1 = new EventListener1();
        EventListener2 listener2 = new EventListener2();
        CustomEvent customEvent = CustomEvent.of(23);
        EventBusUtil.register(listener1);
        EventBusUtil.register(listener2);


        EventBusUtil.post(customEvent);

//        EventBusUtil.asyncPost(customEvent);
//        try {
//            Thread.sleep(1*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Instant.now() + ",主线程执行完毕：" + Thread.currentThread().getName());


        /** EventBus 和AsyncEventBus 不同点:
         * EventBus:同步事件总线

         1.同步执行，事件发送方在发出事件之后，会等待所有的事件消费方执行完毕后，才会回来继续执行自己后面的代码。

         2.事件发送方和事件消费方会在同一个线程中执行，消费方的执行线程取决于发送方。

         3.同一个事件的多个订阅者，在接收到事件的顺序上面有不同。谁先注册到EventBus的，谁先执行，如果是在同一个类中的两个订阅者一起被注册到EventBus的情况，收到事件的顺序跟方法名有关。

         AsyncEventBus:异步事件总线

         1.异步执行，事件发送方异步发出事件，不会等待事件消费方是否收到，直接执行自己后面的代码。

         2.在定义AsyncEventBus时，构造函数中会传入一个线程池。事件消费方收到异步事件时，消费方会从线程池中获取一个新的线程来执行自己的任务。

         3.同一个事件的多个订阅者，它们的注册顺序跟接收到事件的顺序上没有任何联系，都会同时收到事件，并且都是在新的线程中，异步并发的执行自己的任务。
         */
    }
}
