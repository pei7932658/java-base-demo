package com.megvii.sng.dzh.codesample.singleton.configTest;

public class ComposedBean {

    private ComponentBean bean1;
    private ComponentBean bean2;

    public ComponentBean getBean1() {
        return bean1;
    }

    public void setBean1(ComponentBean bean1) {
        this.bean1 = bean1;
    }

    public ComponentBean getBean2() {
        return bean2;
    }

    public void setBean2(ComponentBean bean2) {
        this.bean2 = bean2;
    }
}
