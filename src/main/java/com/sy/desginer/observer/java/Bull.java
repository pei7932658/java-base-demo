package com.sy.desginer.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 具体观察者类：多方
 */
public class Bull implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        OilFutures futures = (OilFutures)o;
        System.out.println("多方验证对象："+futures.getPrice());

        Float price=((Float)arg).floatValue();
        if(price>0)
        {
            System.out.println("油价上涨"+price+"元，多方高兴了！");
        }
        else
        {
            System.out.println("油价下跌"+(-price)+"元，多方伤心了！");
        }
    }
}
