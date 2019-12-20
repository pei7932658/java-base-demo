package com.sy.multiply_if_else.normal;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/30 10:40
 * @Modified By:
 */
public interface ShareNewListener {
    int STATE_SUCC = 0;
    int STATE_FAIL = 1;

    void onCallback(int state, String message);
}
