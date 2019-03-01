package com.sy.factory;

public class Singlleton {
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
	private static Singlleton singlleton =null;
	
	 /* 私有构造方法，防止被实例化 */ 
	private Singlleton(){
		
	}
	
	public static Singlleton getInstance(){
		if(singlleton ==null){
			new Singlleton();
		}
		return singlleton;
	}
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
	public Object readObject(){
		return singlleton;
	}
}
