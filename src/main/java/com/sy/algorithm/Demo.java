package com.sy.algorithm;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */
public class Demo {

    public static int exc1(int mouth) {
        int num=1;
        if (mouth == 1 || mouth ==2) {
            return num;
        }else {
            return exc1(mouth-1)+exc1(mouth-2);
        }
    }

    public static void main(String[] args) {
        System.out.println("第10月有兔子【"+exc1(10)*2+"】只");
    }
}
