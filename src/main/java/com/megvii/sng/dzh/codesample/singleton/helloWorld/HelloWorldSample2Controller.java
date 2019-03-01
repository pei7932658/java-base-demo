package com.megvii.sng.dzh.codesample.singleton.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s2")
public class HelloWorldSample2Controller {

    private String name;

    @Autowired
    private TaskRunner taskRunner;

    /**
     *  说出调用者的名字
     */
    @RequestMapping("/sayHello")
    public String sayHello(String username) throws InterruptedException {
        this.name = username;
        taskRunner.busyDoSomeThing();
        return "Hello\t"+this.name;
    }

}
