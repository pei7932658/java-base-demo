package com.sy.test;

public class P1 extends P {
	
	public void eat(String things){
		System.out.println("p1 eat ");
		work();
	}
	
	public void work(){
		System.out.println("p1 work");
	}
	
	public static void main(String[] args) {
		P p1 = new P1();
		p1.eat();
		
	}
}
