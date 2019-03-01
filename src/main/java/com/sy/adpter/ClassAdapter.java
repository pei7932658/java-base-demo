package com.sy.adpter;

/**
 * 在中间取适配作用的类，可以称为适配器的类
 * @author Administrator
 *
 */
public class ClassAdapter extends Source implements Targetable{

	public void method2() {
		System.out.println("this is the targetable mehtod2");
	}
}
