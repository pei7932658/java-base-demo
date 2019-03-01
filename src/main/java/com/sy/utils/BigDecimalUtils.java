package com.sy.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtils {
	/**
	 * 相加
	 * @param b1
	 * @param b2
	 * @param format
	 * @return
	 */
	public static BigDecimal add(BigDecimal b1,BigDecimal b2,String format){
		DecimalFormat myformat = new DecimalFormat(format);
		return new BigDecimal(myformat.format(b1.add(b2).floatValue()));
	}
	/**
	 * 相减
	 * @param b1
	 * @param b2
	 * @param format
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal b1,BigDecimal b2,String format){
		DecimalFormat myformat = new DecimalFormat(format);
		return new BigDecimal(myformat.format(b1.subtract(b2).floatValue()));
	}
	/**
	 * 格式化小数位
	 * @param b1
	 * @param format
	 * @return
	 */
	public static BigDecimal fromat(BigDecimal b1,String format){
		DecimalFormat myformat = new DecimalFormat(format);
		return new BigDecimal(myformat.format(b1.floatValue()));
	}
	
	
	/**
	 * 乘法
	 * @param b1
	 * @param b2
	 * @param format
	 * @return
	 */
	public static BigDecimal  multipl(BigDecimal b1,BigDecimal b2,String format){
		DecimalFormat myformat = new DecimalFormat(format);
		return new BigDecimal(myformat.format(b1.multiply(b2)));
	}
	/**
	 * 相除
	 * @param b1
	 * @param b2
	 * @param format
	 * @return
	 */
	public static BigDecimal divide(BigDecimal b1,BigDecimal b2,String format){
		DecimalFormat myformat = new DecimalFormat(format);
		return new BigDecimal(myformat.format(b1.floatValue()/b2.floatValue()));
	}
	
	public static void main(String[] args) {
		System.out.println(add(new BigDecimal(0), new BigDecimal("12.36"), "0.00").floatValue());
		System.out.println(divide(new BigDecimal("0.01"), new BigDecimal("240"), "0.00").floatValue());
	}
}
