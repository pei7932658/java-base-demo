package com.sy.pei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateTest {
	public static void main(String[] args) {
		//datetest1();
		//datetest2();
		  datetest3();
		  datetest4();
	}
	
	public static void datetest1(){
		Calendar calendar=Calendar.getInstance();
		   calendar.setTime(new Date()); 
		   calendar.add(Calendar.HOUR_OF_DAY, -24);
		   calendar.set(Calendar.MINUTE, 0);
		   calendar.set(Calendar.SECOND, 0);
		   Date dt1=calendar.getTime();
		   System.out.println(dt1);
		   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  System.out.println(df.format(dt1));
	}
	public static void datetest2(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY, -6);
		Date timeFrom = calendar.getTime();
		 SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(timeFrom));
		calendar.add(Calendar.MINUTE, 5);
		Date timeto = calendar.getTime();
		System.out.println(df.format(timeto));
	}
	public static void datetest3(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			System.out.println(sdf.format(date));
	}
	public static void datetest4(){
		Date tradeDate  = new Date();
		tradeDate.setHours(tradeDate.getHours()+24);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(sdf.format(tradeDate));
	}
	public static Calendar getCalendarByDayAndMinSecClear(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar;
	}
	
	
	
}
