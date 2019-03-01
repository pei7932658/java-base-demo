package com.megvii.sng.dzh.codesample.singleton.configTest;

import java.util.UUID;

public class ComponentBean {

    private String beanId;

    public ComponentBean() {
        this.beanId = UUID.randomUUID().toString();
    }

    public ComponentBean(String beanId) {
        this.beanId = beanId;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }
}
