package com.sy.utils;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2024/11/18 16:54
 * @Modified By:
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String type = "core05_10_02";
        switch (type) {
            case "core0508":
            case "core0508_xy":
            case "core05_10_02":
                System.out.println("core05_10_02");
                break;
            case "core05_10_01":
            case "core05_11_01":
            case "core05_11_02":
            case "core05_11_04":
                System.out.println("core05_11_04");
                break;
            default:
                System.out.println("Unknown type");
        }

    }
}
