package com.sy.multiply_if_else.polymorphi;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/30 10:40
 * @Modified By:
 */
public class Main2 {
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_CONTENT = 1;
    private static final int TYPE_LINK = 2;

    public static void main(String[] args) {

    }

    //所谓接口分层指的是：把接口分为外部和内部接口，所有空值判断放在外部接口完成，只处理一次；而内部接口传入的变量由外部接口保证不为空，从而减少空值判断。

    //外部接口
    public void share(NewItem item, ShareNewListener listener) {
        if (item == null && listener != null) {
            listener.onCallback(ShareNewListener.STATE_FAIL, "NewItem 不能为 null");
            return;
        }

        if (listener == null) {
            return;
        }

        shareImpl(item, listener);
    }

    //内部接口
    public void shareImpl(NewItem item, ShareNewListener listener) {
        switch (item.type) {
            case TYPE_LINK:
                // 分享链接
                if (item.link != null) {
                    doShareLink(item.link, item.content, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareNewListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            case TYPE_TITLE:
                // 分享标题
                if (item.title != null) {
                    doShareText(item.title, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareNewListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            case TYPE_CONTENT:
                // 分享内容
                if (item.content != null) {
                    doShareImageAndText(item.content, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareNewListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            default:
                if (listener != null) {
                    listener.onCallback(ShareNewListener.STATE_FAIL, "不支持的分享类型");
                }
        }
    }


    public void doShareLink(String link, String content, ShareNewListener listener) {

    }

    public void doShareText(String title, ShareNewListener listener) {

    }

    public void doShareImageAndText(String content, ShareNewListener listener) {

    }
}
