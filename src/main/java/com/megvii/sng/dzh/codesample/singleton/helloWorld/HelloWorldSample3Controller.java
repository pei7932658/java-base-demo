package com.megvii.sng.dzh.codesample.singleton.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s3")
public class HelloWorldSample3Controller {

    @Autowired
    private TaskRunner taskRunner;

    /**
     *  说出调用者的名字
     */
    @RequestMapping("/sayHello")
    public String sayHello(String username) throws InterruptedException {
        HelloSayer helloSayer = new HelloSayer();
        helloSayer.setUserName(username);
        taskRunner.busyDoSomeThing();
        return helloSayer.sayHello();
    }

}
