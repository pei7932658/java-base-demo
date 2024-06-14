package com.sy.hutool.collection;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/9/22 15:15
 * @Modified By:
 * @Version: 1.0
 */
public class CollUtilTest {
    public static void main(String[] args) {
        List roles = Arrays.asList("1", "2");
        List roleAll = Arrays.asList("1", "2", "3", "4");
        List roles2 = Arrays.asList("5");
        List roles3 = Arrays.asList("1", "5");

        //containsAny 只会判断两个collectoin，只要有一个元素相同，则返回true
        System.out.println("-----------------containsAny");
        System.out.println(CollUtil.containsAny(roleAll, roles));
        System.out.println(CollUtil.containsAny(roleAll, roles2));
        System.out.println(CollUtil.containsAny(roleAll, roles3));

        //containsAll 如果第一个collectoin，包括后面conllection所有元素则返回true
        System.out.println("-----------------containsAll");
        System.out.println(CollUtil.containsAll(roleAll, roles));
        System.out.println(CollUtil.containsAll(roleAll, roles3));

        System.out.println("-----------------join");
        String[] col = new String[]{"a", "b", "c", "d", "e"};
        List<String> colList = CollUtil.newArrayList(col);
        String str = CollUtil.join(colList, "#"); //str -> a#b#c#d#e

        //需要背景：当后端从不同库中查询出来的数据，想要合并，但此时前端又想要分页，可以用这个方法
        System.out.println("-----------------sortPageAll");
        List<UserModel> users1 = Arrays.asList(UserModel.of(1, "peter1"), UserModel.of(2, "peter2"), UserModel.of(3, "peter3"));
        List<UserModel> users2 = Arrays.asList(UserModel.of(4, "peter4"), UserModel.of(5, "peter5"), UserModel.of(6, "peter6"));
        List<UserModel> users3 = Arrays.asList(UserModel.of(7, "peter7"), UserModel.of(8, "peter8"), UserModel.of(9, "peter9"));

        //Integer比较器
        Comparator<UserModel> comparator = new Comparator<UserModel>() {
            @Override
            public int compare(UserModel o1, UserModel o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        List<UserModel> result = CollUtil.sortPageAll(0, 2, comparator, users2, users1, users3);
        System.out.println(result);

        //数组和list判断是否有相同元素
        String[] str2 = {"1", "2", "4"};
        List<String> listStr = Arrays.asList("4", "5");
        boolean resultMatch = Arrays.stream(str2).anyMatch(s -> {
            return listStr.stream().anyMatch(sl -> sl.equals(s));
        });
        System.out.println(resultMatch);

        //list 根据某个字段排序，复杂的判断，可以自己实现一个Comparator
        List<UserModel> usersSort = Arrays.asList(UserModel.of(5, "peter1"), UserModel.of(17, "peter2"), UserModel.of(3, "peter3"));
        System.out.println(usersSort);
        usersSort.sort(Comparator.comparing(UserModel::getId)); //升序
        //usersSort.sort(Comparator.comparing(UserModel::getId).reversed()); //降序
        System.out.println(usersSort);

        /*
        * List<UserModel> usersRemoveIf = Arrays.asList(UserModel.of(5, "peter1"), UserModel.of(17, "peter2"), UserModel.of(3, "peter3"));
        * 通过Arrays.asList 创建出来的list 是一个static，不支持增删改，所以用于remove时会报错 UnsupportedOperationException
         * */
        // list 根据某个字段值判断，去掉一个元素
        List<UserModel> usersRemoveIf = new ArrayList<>();
        usersRemoveIf.add(UserModel.of(5, "peter1"));
        usersRemoveIf.add(UserModel.of(17, "peter2"));
        usersRemoveIf.add(UserModel.of(3, "peter3"));

        usersRemoveIf.removeIf(user -> user.getId().intValue() == 5);
        System.out.println(usersRemoveIf);

    }
}
