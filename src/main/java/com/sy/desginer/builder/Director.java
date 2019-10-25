package com.sy.desginer.builder;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 16:05
 * @Modified By:
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product makeProduct() {
        builder.setPartA();
        builder.setPartB();
        builder.setPartC();
        return builder.getProduct();
    }
}
