package com.megvii.sng.dzh.codesample.singleton.jdk8.function;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 16:27
 * @Modified By:
 */
public interface T {
    default void m(){
        System.out.println("1");
    }
    static void m2(){
        System.out.println("2");
    }
}
