package com.megvii.sng.dzh.codesample.singleton.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s1")
public class HelloWorldSample1Controller {

    @Autowired
    private HelloSayer helloSayer;

    @Autowired
    private TaskRunner taskRunner;

    /**
     *  说出调用者的名字
     */
    @RequestMapping("/sayHello")
    public String sayHello(String userName) throws InterruptedException {
        helloSayer.setUserName(userName);
        taskRunner.busyDoSomeThing();
        return helloSayer.sayHello();
    }

}
