package com.sy.jdk8.function.functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/6/4 10:23
 * @Modified By:
 */
@Data
@AllArgsConstructor
@ToString
public class Salary {

    private Integer userId;

    private Double salary;

    public Salary(String name) {
        if (name.equals("zhansan")) {
            this.userId = 1;
            this.salary = 10000d;
        } else if (name.equals("lisi")) {
            this.userId = 2;
            this.salary = 21000d;
        } else {
            this.userId = 0;
            this.salary = 0d;
        }
    }

}
