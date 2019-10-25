package com.sy.desginer.birdge;

/**
定义：
 1.抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 2.扩展抽象化（Refined    Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 3.实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 4.具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。

应用场景：
 1.当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 2.当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
 3.当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。
 */
public class ClientTest {
    public static void main(String[] args)
    {
        Implementor imple=new ConcreteImplementorA();
        Abstraction abs=new RefinedAbstraction(imple);
        abs.getPeopleInfo("lucy");
    }
}
