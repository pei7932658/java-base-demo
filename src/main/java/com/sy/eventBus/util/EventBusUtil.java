package com.sy.eventBus.util;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executor;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/12/20 13:42
 * @Modified By:
 */
public class EventBusUtil {
    private static EventBus eventBus;
    private static AsyncEventBus asyncEventBus;
    private static Executor executor = new Executor() {
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    };

    //双重锁单例模式
    private static AsyncEventBus getAsynEventBus() {
        if (asyncEventBus == null) {
            synchronized (AsyncEventBus.class) {
                if (asyncEventBus == null) {
                    asyncEventBus = new AsyncEventBus(executor);
                }
            }
        }
        return asyncEventBus;
    }

    //双重锁单例模式
    private static EventBus getEventBus() {
        if (eventBus == null) {
            synchronized (EventBus.class) {
                if (eventBus == null) {
                    eventBus = new EventBus();
                }
            }
        }
        return eventBus;
    }

    public static void post(Object event) {
        getEventBus().post(event);
    }

    //异步方式发送事件
    public static void asyncPost(Object event) {
        getAsynEventBus().post(event);
    }

    public static void register(Object object) {
        getEventBus().register(object);
        getAsynEventBus().register(object);
    }
}
