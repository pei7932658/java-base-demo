package com.sy.jdk8;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 20:26
 * @Modified By:
 */
public class javatime {
    public static void main(String[] args) {
        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //获取当前日期
        LocalDate date = LocalDate.now();
        System.out.println(date);


        //获取当前日期
        LocalDateTime dateTime =  LocalDateTime.now();
        System.out.println(dateTime);

        //格式化
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime.format(sf));
    }
}
