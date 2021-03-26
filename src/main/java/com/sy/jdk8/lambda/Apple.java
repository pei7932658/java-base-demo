package com.sy.jdk8.lambda;

import lombok.*;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/4 16:51
 * @Modified By:
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor

@ToString
public class Apple {

    private String color;

    private int weight;

    public Apple(String color) {
        this.color = color;
    }

}
