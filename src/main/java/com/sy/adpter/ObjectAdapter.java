package com.sy.adpter;

/**
 * 对象适配器，不继承source类，而是执有它的实例对象
 * @author Administrator
 *
 */
public class ObjectAdapter implements Targetable{
	private Source source;
	public ObjectAdapter(){
		source = new Source();
	}
	public void method1() {
		source.method1();
	}

	public void method2() {
		System.out.println("this is the targetable mehtod2");
	}
}
