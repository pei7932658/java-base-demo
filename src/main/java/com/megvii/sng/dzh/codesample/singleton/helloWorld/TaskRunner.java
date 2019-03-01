package com.megvii.sng.dzh.codesample.singleton.helloWorld;

import org.springframework.stereotype.Component;

@Component
public class TaskRunner {

    public void busyDoSomeThing() throws InterruptedException {
        Thread.sleep(1000);
    }
}
