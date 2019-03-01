package com.megvii.sng.dzh.codesample.singleton.jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 16:05
 * @Modified By:
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Predicate<Integer> predicate = n -> true;//这时表示test 方法，一直返回true

        System.out.println("输出所有数据");
        //eval(list, predicate);//for 里面if都是true

        Predicate<Integer> predicate1 = n->n%2==0; //test 方法执行的是 n%2==0
        //eval(list,predicate1);

        Predicate<Integer> predicate2 = n-> n>3;
        eval(list,predicate2);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }


}
