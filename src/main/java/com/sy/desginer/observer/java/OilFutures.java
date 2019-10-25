package com.sy.desginer.observer.java;

import java.util.Observable;

/**
原油期货目标类
 */
public class OilFutures extends Observable{
    private float price;
    public float getPrice()
    {
        return this.price;
    }
    public void setPrice(float price)
    {
        super.setChanged() ;  //设置内部标志位，注明数据发生变化
        this.price=price ;
        super.notifyObservers(price);    //通知观察者价格改变了
    }
}
