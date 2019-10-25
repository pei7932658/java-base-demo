package com.sy.desginer.birdge;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 18:08
 * @Modified By:
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void getPeopleInfo(String userId) {
        if (userId.equals("zhangsan")) {
            System.out.print("姓名：张三");
            imple.getSex(1);
            System.out.println();
        } else if (userId.equals("lisi")) {
            System.out.print("姓名：李四");
            imple.getSex(1);
            System.out.println();
        } else if (userId.equals("lucy")) {
            System.out.print("姓名：lucy");
            imple.getSex(0);
            System.out.println();
        }

    }
}
