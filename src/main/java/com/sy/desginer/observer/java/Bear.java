package com.sy.desginer.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/17 13:59
 * @Modified By:
 */
public class Bear implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        OilFutures futures = (OilFutures)o;
        System.out.println("空方验证对象："+futures.getPrice());


        Float price=((Float)arg).floatValue();
        if(price>0)
        {
            System.out.println("油价上涨"+price+"元，空方伤心了！");
        }
        else
        {
            System.out.println("油价下跌"+(-price)+"元，空方高兴了！");
        }
    }
}
