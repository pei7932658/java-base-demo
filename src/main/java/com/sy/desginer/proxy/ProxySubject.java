package com.sy.desginer.proxy;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 16:58
 * @Modified By:
 */
public class ProxySubject implements Subject{

    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();

    }

    public void preRequest(){
        System.out.println("访问真实主题的预处理...");
    }

    public void postRequest(){
        System.out.println("访问真实主题的后处理...");
    }
}
