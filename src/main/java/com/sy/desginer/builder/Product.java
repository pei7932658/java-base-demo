package com.sy.desginer.builder;

import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/15 16:00
 * @Modified By:
 */
@Data
public class Product {

    private String partA;

    private String partB;

    private String partC;

    public void show() {
        System.out.println("Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}');
    }

}
