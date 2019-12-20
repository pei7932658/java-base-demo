package com.sy.multiply_if_else.polymorphi;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/30 10:38
 * @Modified By:
 */
public abstract class NewItem {

    int type;
    String title;
    String content;
    String link;

    public NewItem(){}

    public NewItem(int type, String title, String content, String link) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.link = link;
    }

    public abstract void share(NewItem item, ShareNewListener listener);

}
