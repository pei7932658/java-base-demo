package com.sy.desginer.chain;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/17 11:10
 * @Modified By:
 *
 * 院长类
 */
public class DepartmentHead extends Leader {

    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 10) {
            System.out.println("院长批准您的请假" + leaveDays + "天");
        } else {
            if (getLeader() != null) {
                getLeader().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
