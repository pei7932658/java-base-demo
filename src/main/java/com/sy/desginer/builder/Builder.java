package com.sy.desginer.builder;


public abstract class Builder {
    protected Product product = new Product();

    public abstract void setPartA();
    public abstract void setPartB();
    public abstract void setPartC();

    public Product getProduct() {
        return product;
    }
}
