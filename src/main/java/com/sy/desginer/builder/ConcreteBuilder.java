package com.sy.desginer.builder;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 16:02
 * @Modified By:
 */
public class ConcreteBuilder extends Builder{

    @Override
    public void setPartA() {
        this.product.setPartA("建造 PartA");
    }

    @Override
    public void setPartB() {
        this.product.setPartB("建造 PartB");
    }

    @Override
    public void setPartC() {
        this.product.setPartC("建造 PartC");
    }
}
