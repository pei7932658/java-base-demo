package com.sy.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class A {
	
	
	public static void main(String[] args) {
//		B b = new B();
//		b.setAge(1);
//		b.setName("peter");
//		test(b);
//		System.out.println(b.getAge()+" "+b.getName());
		String img="Peter[0xf0][0x9f][0x91][0x99][0xf0][0x9f][0x91][0x99]";
		System.out.println(EmojiFilter.filterEmoji(img));
		
	}
	public static void test(B b){
		System.out.println(b.getAge()+" "+b.getName());
		b.setAge(2);
		b.setName("peter2");
	}
}

class B{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
