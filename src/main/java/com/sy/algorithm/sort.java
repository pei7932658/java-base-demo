package com.sy.algorithm;

import java.util.Arrays;

/**
 * 排序：
 */
public class sort {
    public static void main(String[] args) {
//        testBinarySearch1();
//        testBubbleSort1();
        testInsertSort1();
    }

    /**
     * 二分查找：
     *
     * @param list   有序列表
     * @param target 待查元素
     * @return 返回是待查元素在列表中的位置 index
     */
    public static int binarySearch1(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list[mid] == target) {
                return mid;
            } else if (list[mid] < target) {
                left = mid + 1;
            } else if (list[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void testBinarySearch1() {
        //        int index = binarySearch1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 7);
        int index = binarySearch1(new int[]{4, 6, 2, 1, 11, 8, 7, 3, 7, 10, 5}, 7);
        System.out.println(index);

        //下面这样查询不出来
        System.out.println(Arrays.binarySearch(new int[]{4, 6, 2, 1, 11, 8, 9, 3, 7, 10, 5}, 7));
    }

    /**
     * 冒泡排序：
     *
     * @param list 无顺序的列表
     * @param n    列表的长度
     */
    public static void bubbleSort1(int[] list, int n) {
        for (int i = 0; i < n; i++) { //表示n 次排序过程
            for (int j = 1; j < n - i; j++) {
                if (list[j - 1] > list[j]) {
                    int temp;
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public static void testBubbleSort1() {
        int[] list = new int[]{4, 6, 2, 1, 11, 8, 7, 3, 7, 10, 5};
        bubbleSort1(list, list.length);
        System.out.println(Arrays.toString(list));
    }

    /**
     * 1、从第二个元素开始循环遍历，作为参考值，认定参考值左边的元素都有序。
     * 2、取出参考值的下一个元素，在已经排序的元素序列中从后向前扫描。
     * 3、如果该元素（已排序）大于新元素，则将该元素移到下一位置。
     * 4、重复步骤3，直到找到已排序的元素小于新元素的位置。
     * 5、将新元素插入到该位置。
     * 6、重复步骤2。
     *
     * @param list 要排序的列表
     */
    public static void insertSort1(int[] list) {
        for (int i = 1; i < list.length; i++) {
            //要插入的数，从第二个开始
            int insertVal = list[i];
            //被插入的位置（准备和前面一个数进行比对）
            int index = i - 1;

            while (index >= 0 && insertVal < list[index]) {
                //将list[index]向后移动
                list[index + 1] = list[index];
                //将index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            list[index + 1] = insertVal;
        }
    }

    public static void testInsertSort1() {
        int[] list = new int[]{4, 6, 2, 1, 11, 8, 7, 3, 7, 10, 5};
        insertSort1(list);
        System.out.println(Arrays.toString(list));
    }
}
