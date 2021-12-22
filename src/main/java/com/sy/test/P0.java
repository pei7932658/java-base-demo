package com.sy.test;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public abstract class P0 {
    protected abstract void method1(String s);

    protected final void test1(){
        System.out.println("father test1");
        method1("abc");
    }
}
