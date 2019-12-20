package com.sy.multiply_if_else.normal;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/30 10:40
 * @Modified By:
 */
public class Main {
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_CONTENT = 1;
    private static final int TYPE_LINK = 2;

    public static void main(String[] args) {

    }

    //最原始的写法，叠加多个If else
    public void share(NewItem item, ShareNewListener listener) {
        if (item != null) {
            if (item.type == TYPE_LINK) {
                // 分享链接
                if (item.link != null) {
                    doShareLink(item.link, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareNewListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else if (item.type == TYPE_TITLE) {
                // 分享标题
                if (item.title != null) {
                    doShareText(item.title, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareNewListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else if (item.type == TYPE_CONTENT) {
                // 分享内容
                if (item.content != null) {
                    doShareImageAndText(item.content, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareNewListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else {
                if (listener != null) {
                    listener.onCallback(ShareNewListener.STATE_FAIL, "不支持的分享类型");
                }
            }
        } else {
            if (listener != null) {
                listener.onCallback(ShareNewListener.STATE_FAIL, "NewItem 不能为 null");
            }
        }
    }

    public void doShareLink(String link, ShareNewListener listener) {

    }

    public void doShareText(String title, ShareNewListener listener) {

    }

    public void doShareImageAndText(String content, ShareNewListener listener) {

    }
}
