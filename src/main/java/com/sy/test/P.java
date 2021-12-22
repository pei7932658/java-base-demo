package com.sy.test;

public class P extends P0 {
    public void eat() {
        System.out.println("p eat");
        work();
    }

    public void work() {
        super.test1();
        System.out.println("p work");
    }

    @Override
    protected void method1(String s) {
        System.out.println("sun impl father method1");
    }

    public static void main(String[] args) {
        P p = new P();
        p.work();
    }
}
