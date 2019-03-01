package com.sy.adpter;

public class TestTargetable {
	public static void main(String[] args) {
//		objectAdapterTest();
		objectAdapterTest();
	}
	public static void classAdapterTest(){
		Targetable target = new ClassAdapter();
		/**
		 * 通过适配器类adapter类使target能引用到原类source方法
		 */
		target.method1();
		
		target.method2();
	}
	public static void objectAdapterTest(){
		Targetable target = new ObjectAdapter();
		/**
		 * 通过对象适配器adapter类使target能引用到原类source方法
		 */
		target.method1();
		
		target.method2();
	}
}
