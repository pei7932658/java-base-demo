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
        int num = 1;
        if (mouth == 1 || mouth == 2) {
            return num;
        } else {
            return exc1(mouth - 1) + exc1(mouth - 2);
        }
    }

    public static boolean isZhishu(int x) {
        boolean flag = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String isLevel(double score) {
        return score >= 90 ? "A" : (score < 60 ? "C" : "B");
    }

    public static double fall(double height, int c) {
        double s = 0;
        double temp = 0;

        for (int i = 1; i <= c; i++) {
            temp = height / 2;
            s += height + temp;
            height = temp;
        }
        return s;
    }

    public static void association() {
        int i = 0;
        int j = 0;
        int k = 0;
        int t = 0;
        for (i = 1; i <= 4; i++)
            for (j = 1; j <= 4; j++)
                for (k = 1; k <= 4; k++)
                    if (i != j && j != k && i != k) {
                        t += 1;
                        System.out.println(i * 100 + j * 10 + k);
                    }
        System.out.println(t);
    }

    public static void main(String[] args) {
        //1、古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
        //System.out.println("第10月有兔子【" + exc1(10) * 2 + "】只");

        //2、判断101-200之间有多少个素数，并输出所有素数
        System.out.print("101到200之间的质数有:");
        for (int i = 101; i <= 200; i++) {
            if (isZhishu(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //3、利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
        System.out.println(isLevel(91d));
        System.out.println(isLevel(53d));
        System.out.println(isLevel(72d));

        //4、一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
        System.out.println("100米,落2次，共经过" + fall(100d, 10));

        //5、有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
        association();
    }
}
