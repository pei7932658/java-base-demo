package com.sy.reflect;

import java.lang.reflect.Proxy;

public class TestLogHandler {
	public static void main(String[] args) {
		//jdkReflect();
		
		cglibReflect();
	}
	
	public static void jdkReflect(){
		UserService target = new UserServiceImpl();
		
		LogHandler logHandler = new LogHandler(target);
		System.out.println(target.getClass().getInterfaces()[0].getName());
		UserService proxy = (UserService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), logHandler);
		proxy.insertUser(1);
		proxy.deleteUser(2);
	}
	
	public static void cglibReflect(){
		CglibProxy proxy = new CglibProxy();
		UserServiceImpl userServiceImpl = (UserServiceImpl)proxy.getProxy(UserServiceImpl.class);
		userServiceImpl.insertUser(1);
		userServiceImpl.deleteUser(2);
	}
}
