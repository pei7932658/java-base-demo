package com.sy.desginer.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/17 13:28
 * @Modified By:
 * 汇率
 */
public abstract class Rate {
    protected List<Company> companies = new ArrayList<>();

    //增加观察者方法
    public Rate add(Company company) {
        companies.add(company);
        return this;
    }

    //删除观察者方法
    public Rate remove(Company company) {
        companies.remove(company);
        return this;
    }

    public abstract void change(int number);
}
