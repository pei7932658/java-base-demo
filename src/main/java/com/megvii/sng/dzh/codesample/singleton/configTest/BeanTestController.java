package com.megvii.sng.dzh.codesample.singleton.configTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beanTest")
public class BeanTestController {

    @Autowired
    ComposedBean composedBean;

    @RequestMapping("/")
    public String testIfBeansAreTheSame(){
        return composedBean.getBean1().getBeanId() + "\n" + composedBean.getBean2().getBeanId();
    }
}
