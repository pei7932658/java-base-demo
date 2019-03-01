package com.sy.factory;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		Creater create = new ManFactory();
		create.create().eat();
	}
}
