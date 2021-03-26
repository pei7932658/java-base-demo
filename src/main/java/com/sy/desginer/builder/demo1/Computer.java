package com.sy.desginer.builder.demo1;

/**
 当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式
 */

public class Computer {
    private final String cpu;//必须
    private final String ram;//必须
    private final int usbCount;//可选
    private final String keyboard;//可选
    private final String display;//可选

    public Computer(Builder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.usbCount=builder.usbCount;
        this.keyboard=builder.keyboard;
        this.display=builder.display;
    }
    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Computer computer= new Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setUsbCount(2)
                .setKeyborad("罗技")
                .builder();

        System.out.println(computer);
    }
}

class Builder {
    public String cpu;//必须
    public String ram;//必须
    public int usbCount;//可选
    public String keyboard;//可选
    public String display;//可选

    public Builder(String cup, String ram) {
        this.cpu = cup;
        this.ram = ram;
    }

    public Builder setUsbCount(int usbCount) {
        this.usbCount = usbCount;
        return this;
    }
    public Builder setKeyborad(String keyboard){
        this.keyboard=keyboard;
        return this;
    }
    public Builder setDisplay(String display){
        this.display=display;
        return this;
    }


    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getDisplay() {
        return display;
    }

    public Computer builder(){
        return new Computer(this);
    }
}

