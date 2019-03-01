package com.sy.math;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
//		compareTo();
		format();
	}
	public static void compareTo(){
		BigDecimal bd = new BigDecimal("1.3");
		BigDecimal b2 = new BigDecimal("1.2");
		System.out.println(bd.compareTo(b2));
	}

	public static void format() {
		float c = 3.156215f;
		java.text.DecimalFormat myformat = new java.text.DecimalFormat("0.00");
		String str = myformat.format(c);
		System.out.println(str);
	}
}
