package com.megvii.sng.dzh.codesample.singleton.lombok;

import lombok.*;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/4 15:19
 * @Modified By:
 */
@Data //geter seter

@AllArgsConstructor(staticName = "of")//所有属性构造方法

@RequiredArgsConstructor(staticName = "name")

@NoArgsConstructor//空构造方法

@ToString(includeFieldNames=false,exclude = {"name"}) //实现toString 方法
public class User {

    //AllArgsConstructor 和NonNull 一起使用时，此属性在对象构造时不能为null
    @NonNull  private String name;

    private String sex;

    private Integer age;
}
