package com.megvii.sng.dzh.codesample.singleton.jdk8.function;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 16:28
 * @Modified By:
 */
public class At implements T {
    public static void main(String[] args) {
        At at = new At();
        at.m();
        T.m2();

    }

    @Override
    public void m() {
        System.out.println("1_1");
    }

}
