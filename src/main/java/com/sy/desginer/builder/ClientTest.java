package com.sy.desginer.builder;

/**
 * 定义：
 1.产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
 2.抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 3.具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 4.指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。

 应用场景：建造者（Builder）模式创建的是复杂对象，其产品的各个部分经常面临着剧烈的变化，但将它们组合在一起的算法却相对稳定，所以它通常在以下场合使用。
 1.创建的对象较复杂，由多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的。
 2.创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的。
 */
public class ClientTest {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.makeProduct();

        product.show();
    }
}
