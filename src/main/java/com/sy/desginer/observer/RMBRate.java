package com.sy.desginer.observer;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/17 13:32
 * @Modified By:
 */
public class RMBRate extends Rate {

    @Override
    public void change(int number) {
        for (Company c : companies) {
            c.response(number);
        }
    }
}
