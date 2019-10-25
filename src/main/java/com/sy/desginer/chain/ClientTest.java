package com.sy.desginer.chain;

/**
角色定义：
 1.抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 2.具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 3.客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。

应用场景：
 1.有多个对象可以处理一个请求，哪个对象处理该请求由运行时刻自动确定。
 2.可动态指定一组对象处理请求，或添加新的处理者。
 3.在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求。
 */
public class ClientTest {
    public static void main(String[] args) {

        /*  场景:
            假如规定学生请假小于或等于 2 天，班主任可以批准；小于或等于 7 天，系主任可以批准；小于或等于 10 天，院长可以批准；其他情况不予批准；这个实例适合使用职责链模式实现。
         */
        Leader classAdviser = new ClassAdviser();
        Leader dean = new Dean();
        Leader departmentHead = new DepartmentHead();

        classAdviser.setLeader(dean);
        dean.setLeader(departmentHead);

        classAdviser.handleRequest(12);

    }
}
