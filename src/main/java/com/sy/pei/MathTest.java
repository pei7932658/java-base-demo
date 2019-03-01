package com.sy.pei;

import java.math.BigDecimal;

public class MathTest {
	public static void main(String[] args) {
		BigDecimalTest();
	}

	public static void BigDecimalTest(){
		BigDecimal bd = new BigDecimal(17.32);
		System.out.println(bd.floatValue());
		System.out.println(bd.hashCode());
		System.out.println(bd.intValue());
		BigDecimal bd1 = new BigDecimal("10.123");
	    BigDecimal bd2 = new BigDecimal(10.123);
	    System.out.println(bd1 +" : "+ bd2);
		
	}
}