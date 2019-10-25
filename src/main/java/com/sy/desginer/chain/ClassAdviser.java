package com.sy.desginer.chain;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/17 11:10
 * @Modified By:
 * 班主任
 */
public class ClassAdviser extends Leader {

    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 2) {
            System.out.println("班主任批准您的请假" + leaveDays + "天");
        } else {
            if (getLeader() != null) {
                getLeader().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
