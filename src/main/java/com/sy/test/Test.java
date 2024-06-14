package com.sy.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = Model.class.getClassLoader();
		System.out.println(loader);
		
		//loader.loadClass 只把.class文件加载到jvm中
		//loader.loadClass("com.sy.test.Model");
		
		//Class.forName() 不仅把.class文件加载到jvm中，还会对类进行解释，执行类中static块的内容
		//Class.forName("com.sy.test.Model"); 
		
		//Class.forName("com.sy.test.Model",true,loader);
		
//		System.out.println(test1("20171129","21:33:22"));
//		System.out.println(getMaxMonthDate());
//		Student s = new Student();
//				s.setAge(12);
//				s.setName("pei");
//		change(s);
//		System.out.println(s);
		
		
		//testMap();

		//testCompile("41090000001200000110");

		System.out.println(String.valueOf(System.currentTimeMillis() / 1000));
		System.out.println((new Date().getTime()+"").substring(0,10));
	}
	
	public static String test1(String tradeDt, String tradeTm){
		if(Integer.valueOf(tradeTm.substring(0, tradeTm.indexOf(":"))) >= 21){
			if(Integer.parseInt(tradeDt.substring(6, 8)) == getMaxMonthDate()){
				return tradeDt;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar now = Calendar.getInstance();
			try {
				now.setTime(sdf.parse(tradeDt));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			now.add(Calendar.DAY_OF_MONTH, 1);
			return sdf.format(now.getTime());
		}else{
			return tradeDt;
		}
	}
	
    public static int getMaxMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime().getDate();
    }
    
    public static void change(Student s){
    	s.setAge(10);
    	s.setName("liang");
    }
    
    public static void testMap(){
    	StringBuffer sql = new StringBuffer();
		sql.append("select user.name username, user.mobile, user.type, mer.name mername, temp.usable, temp.settle from(  ");
		sql.append("select userid, sum(usableBalance) usable, sum(settleAmount) settle from app_account ");
		sql.append("group by userid having usable>0 or settle>0 ");
		sql.append(") temp  ");
		sql.append("left join app_user user on temp.userid = user.id  ");
		sql.append("left join app_salesper_mer mr on mr.userid = user.id and mr.role = 1 ");
		sql.append("left join app_merchant mer on mr.merid = mer.id ");
		sql.append("WHERE 1=1 ");
		//sql.append(" AND mer.name like '%"+data.getMerName()+"%' ");
		//sql.append(" AND user.name like '%"+data.getUserName()+"%' ");
		//sql.append(" AND user.type = "+data.getUsertype());
		System.out.println(sql.toString());
    }

	public static void testCompile(String str){
		String pattern = "^[0-9]{10}[1][2][0][0-9]{7}$";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
	}
}
