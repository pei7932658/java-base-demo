package com.sy.desginer.birdge;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 18:07
 * @Modified By:
 */
public class ConcreteImplementorA implements Implementor{
    @Override
    public void getSex(int sex) {
        if (1 == sex){
            System.out.print("、性别是：男" );
        }else{
            System.out.print("、性别是：女" );
        }

    }
}
