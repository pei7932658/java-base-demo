package com.sy.multiply_if_else.polymorphi;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/30 13:13
 * @Modified By:
 */
public class TitleItem extends NewItem {
    String title;

    public TitleItem(String title) {
        this.title = title;
    }

    @Override
    public void share(NewItem item, ShareNewListener listener) {

    }

    public void doShareText(String title, ShareNewListener listener) {

    }
}
