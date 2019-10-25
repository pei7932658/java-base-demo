package com.sy.desginer.chain;

import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/17 11:06
 * @Modified By:
 */
@Data
public abstract class Leader {
    private Leader leader;

    public abstract void handleRequest(int leaveDays);
}
