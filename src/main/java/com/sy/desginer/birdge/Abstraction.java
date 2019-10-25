package com.sy.desginer.birdge;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 18:08
 * @Modified By:
 */
public abstract  class Abstraction {
    protected Implementor imple;
    protected Abstraction(Implementor imple)
    {
        this.imple=imple;
    }
    public abstract void getPeopleInfo(String userId);
}
