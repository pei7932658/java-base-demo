package com.megvii.sng.dzh.codesample.singleton.jdk8;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 20:26
 * @Modified By:
 */
public class javatime {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDateTime dateTime =  LocalDateTime.now();
        System.out.println(dateTime);
    }
}
