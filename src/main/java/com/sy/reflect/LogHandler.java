package com.sy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{
	
	private Object target;
	
	public LogHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
		
		Object obj = method.invoke(target, args);// ③-2通过反射方法调用业务类的目标方法  
		
		PerformanceMonitor.end();
		
		return obj;
	}

}
