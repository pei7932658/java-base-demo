package com.sy.jdk8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2024/3/12 14:07
 * @Modified By:
 * @Version: 1.0
 */
public class DateTimeFormatterTest {

    public final static DateTimeFormatter FORMATTER0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public final static DateTimeFormatter FORMATTER4 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(String date) {
        return LocalDateTime.parse(date, FORMATTER4);
    }


    public static void main(String[] args) {
//        LocalDateTime localDateTime = toLocalDateTime(new Date());
//        System.out.println(localDateTime.format(FORMATTER0));
//        System.out.println(localDateTime.format(FORMATTER4));
//
//        LocalDateTime localDateTime1 = toLocalDateTime("20240312141005");
//        System.out.println( localDateTime1.toLocalDate());
//        System.out.println( localDateTime1.toLocalTime());



        //ofLocalizedDate
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
//格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter1.format(localDateTime);
        String str2 = formatter2.format(localDateTime);
        String str3 = formatter3.format(localDateTime);
        System.out.println("格式化之前："+localDateTime);//2021-07-21T18:47:28.994
        System.out.println("格式化之后SHORT："+str1);//21-7-21
        System.out.println("格式化之后LONG："+str2);//2021年7月21日
        System.out.println("格式化之后MEDIUM："+str3);//2021-7-21

//解析：字符串-->日期
        TemporalAccessor parse1 = formatter1.parse("21-7-21");
        TemporalAccessor parse2 = formatter2.parse("2021年7月21日");
        TemporalAccessor parse3 = formatter3.parse("2021-7-21");

        System.out.println(parse1);//{},ISO resolved to 2021-07-21
        System.out.println(parse1);//{},ISO resolved to 2021-07-21
        System.out.println(parse3);//{},ISO resolved to 2021-07-21


    }

}
