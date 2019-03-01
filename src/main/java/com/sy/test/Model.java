package com.sy.test;

import java.io.Serializable;


public class Model implements Serializable{
	private static int age =0;
	
	static {
		System.out.println("model init");
		System.out.println(age);
	}
	
	public Model(){
		this.age = 1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
