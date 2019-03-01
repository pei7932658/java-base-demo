package com.sy.reflect;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz) {  
        enhancer.setSuperclass(clazz); //① 设置需要创建子类的类  
        enhancer.setCallback(this);   
        return enhancer.create(); //②通过字节码技术动态创建子类实例  
    } 
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		   PerformanceMonitor.begin(obj.getClass().getName()+"."+method. getName());//③-1  
		 
	       Object result=proxy.invokeSuper(obj, args);
	       
	       PerformanceMonitor.end();//③-1通过代理类调用父类中的方法  
	       
	       return result;  
	}

}
