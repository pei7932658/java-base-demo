package com.sy.hutool.util;

import cn.hutool.core.util.StrUtil;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/9/22 16:45
 * @Modified By:
 * @Version: 1.0
 */
public class StrUtilDemo {
    public static void main(String[] args) {
        String s =null;
        String s1="";
        String s2="123";
        String s3=" 1 23";

        //常用于判断好多字段是否有空的（例如web表单数据）
        System.out.println("-----------------hasBlank");
        System.out.println(StrUtil.hasBlank(s,s2));
        System.out.println(StrUtil.hasBlank(s1,s2));
        System.out.println(StrUtil.isAllBlank(s1,s2));
        System.out.println(StrUtil.hasBlank(s3));

        System.out.println("-----------------hasEmpty");
        System.out.println(StrUtil.hasEmpty(s,s2));
        System.out.println(StrUtil.hasEmpty(s1,s2));
        System.out.println(StrUtil.isAllEmpty(s1,s2));
        System.out.println(StrUtil.hasEmpty(s3));

        //去掉字符串的前缀后缀的，例如去个文件名的扩展名啥。
        System.out.println("-----------------removeSuffix、removePrefix");
        String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg");  //fileName -> pretty_girl
        String fileName2 = StrUtil.removeSuffixIgnoreCase("pretty_girl.JPG", ".jpg");  //fileName -> pretty_girl
        System.out.println(fileName2);

        String fileName3 = StrUtil.removePrefix("pretty_girl.JPG", "pretty");  //fileName -> _girl.JPG
        String fileName4 = StrUtil.removePrefixIgnoreCase("PRETTY_girl.JPG", "pretty");  //fileName -> _girl.JPG
        System.out.println(fileName4);

        System.out.println("-----------------format");
        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, "我", "你"); //str -> 我爱你，就像老鼠爱大米
        System.out.println(str);
    }
}
