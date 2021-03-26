package com.sy.jdk8.function.functionalInterface;

import java.util.Random;

/**
 * @Author:peiliang
 * @Description:
 * 1.FunctionalInterface 注解是非必须的，只要符合函数式接口标准(接口有且只能有个一个抽象方法)，但最好加上，免得其它团队成团不清楚，加上其它抽象方法
 * 2.默认方法可以在不影响原来实现类的情况下提供便利
 * @Date:2019/6/3 16:54
 * @Modified By:
 */
@FunctionalInterface
public interface UserHandle {

    /**
     * 通过人员姓名获取人员工资，每个人计算工资方式不一样
     *
     * @param name
     * @return
     */
    Salary getSalary(String name);

    String toString();  //Object中的方法

    @Override
    boolean equals(Object obj); //Object中的方法

    /**
     * 通过UserId 随机一个 user key
     *
     * @param userId
     * @return
     */
    default String getkeyById(Integer userId) {
        return "key-" + userId + "-" + new Random().nextInt(1000);
    }
}
