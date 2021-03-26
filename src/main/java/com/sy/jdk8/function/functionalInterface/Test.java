package com.sy.jdk8.function.functionalInterface;

/**
 * @Author:peiliang
 * @Description: 函数式接口有三种方式：lambda方式、方法引用、构造方法
 * @Date:2019/6/3 17:14
 * @Modified By:
 */
public class Test {
    /**
     * 函数式接口创建:lambda 方式
     * 这种形式最为直观，lambda表达式，接收一个String类型的参数，返回一个Salary类型的结果
     */
    public static void initWithLambda() {
        UserHandle userHandle = name -> {
            if (name.equals("zhansan")) {
                return new Salary(1, 10000d);
            } else if (name.equals("lisi")) {
                return new Salary(1, 210000d);
            } else {
                return new Salary(0, 0d);
            }
        };

        Salary salary = userHandle.getSalary("zhansan");
        System.out.println(salary);
        System.out.println(userHandle.getkeyById(1000));
    }

    /**
     * 函数式接口创建: 方法引用
     * 函数式接口只是定义了个方法的约定（接收一个String类型的参数，返回一个Salary类型的结果）
     * 函数式接口更偏重于计算过程，约束了一个计算过程的输入和输出
     */
    public static void initWithMethod() {
        UserHandle userHandle = Test::getSalaryMethod;
        Salary salary = userHandle.getSalary("lisi");
        System.out.println(salary);
        System.out.println(userHandle.getkeyById(1000));
    }

    private static Salary getSalaryMethod(String name) {
        if (name.equals("zhansan")) {
            return new Salary(1, 10000d);
        } else if (name.equals("lisi")) {
            return new Salary(1, 210000d);
        } else {
            return new Salary(0, 0d);
        }
    }

    /**
     * 函数式接口创建: 构造方法
     * JDK的编译器已经帮我们自动找到了只有一个参数，且是String类型的构造方法,返回Salary
     */
    public static void initWithConstructMethod() {
        UserHandle userHandle = Salary::new;
        Salary salary = userHandle.getSalary("zhansan");
        System.out.println(salary);
        System.out.println(userHandle.getkeyById(1000));
    }


    public static void main(String[] args) {
        initWithConstructMethod();
    }

}

