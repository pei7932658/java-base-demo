package com.megvii.sng.dzh.codesample.singleton.helloWorld;

import org.springframework.stereotype.Component;

@Component
public class HelloSayer {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String sayHello(){
        return "Hello\t"+this.userName;
    }
}
