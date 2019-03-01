package com.megvii.sng.dzh.codesample.singleton.configTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeanTest {

    @Bean
    public ComponentBean componentBean(){
        return new ComponentBean();
    }

    @Bean
    public ComposedBean composedBean(){
        ComposedBean composedBean = new ComposedBean();
        composedBean.setBean1(componentBean());
        composedBean.setBean2(componentBean());
        return  composedBean;
    }
}
