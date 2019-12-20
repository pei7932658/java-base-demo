package com.megvii.sng.dzh.codesample.singleton.jdk8.optional;

import lombok.Data;
import org.junit.Assert;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 20:12
 * @Modified By:
 */
public class OptionalTest {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //-------------------------------------------------------of  ofNullable-------------------------------------------------------//
//        Optional<Integer> a = Optional.of(value1);//value1 初始化时不能为空
//         Optional<Integer> b = Optional.ofNullable(value2); //可以为空

        //System.out.println(sum(a,b));


        //-------------------------------------------------------isPresent ifPresent-------------------------------------------------------//
        //        User u = User.of(null, null);//构造方法
//        User u = null;
//        User u = User.of(null, 23);//构造方法
//        Assert.assertEquals("peter", u.getName());
//        Optional<User> up = Optional.ofNullable(u);
//        System.out.println("对象是否存在:" + up.isPresent());
//        up.ifPresent(user -> System.out.println("ifPresent 判断不为空，执行里面在的Consumer:" + user.getName()));
//        Optional.ofNullable(u).ifPresent(user -> Optional.ofNullable(user.getName()).ifPresent(name -> System.out.println("name:" + name)));

        //-------------------------------------------------------orElse orElseGet-------------------------------------------------------//
//        User u = null;
//        User u = User.of("peter", 23);//构造方法
//        User user = Optional.ofNullable(u).orElse(createNewUser("orElse"));//当对象不为空时，orElse 里面的方法会调用
//        User user2 = Optional.ofNullable(u).orElseGet(()->createNewUser("orElseGet"));//当对象不为空时，orElseGet 不会调用


        //-------------------------------------------------------orElseThrow-------------------------------------------------------//
//        User u =null;
//        Optional.ofNullable(u).orElseThrow(()->new IllegalArgumentException());//如果对应为null 抛出自定义异常


        //-------------------------------------------------------转换值 map flatMap filter-------------------------------------------------------//
//        User u =null;
        User u = User.of("peter", 23);
        //map 无限级联，可以往一直往下走
        String result = Optional.ofNullable(u).map(user -> user.getName()).map(name -> name.toUpperCase()).orElse("map");
        System.out.println(result);
//
//        String result2 = Optional.ofNullable(u).flatMap(user->user.getPosition()).orElse("flatMap");//flatMap 可以对Optional 进行解包
//        System.out.println(result2);

//        User uFilter = User.of("peter@", 23);
//        Optional<User> op = Optional.ofNullable(uFilter).filter(user->user.getName()!=null && user.getName().contains("@"));//filter 接收一个断言，如果满足返回true 返回，如果不满足返回false时返回一个空的Optional
//        Assert.assertTrue(op.isPresent());
//        System.out.println(op.get());

    }

    private static User createNewUser(String method) {
        System.out.println("Creating New User with method:"+method);
        return User.of("extra@gmail.com", 12);
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

        Integer value1 = a.orElse(0);//a 如果为空给默认值
        Integer value2 = b.get();
        return value1 + value2;
    }

}
