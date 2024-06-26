package com.sy.jdk8.lambda;

import lombok.Data;
import lombok.ToString;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2018/12/26 21:41
 * @Modified By:
 */
@Data
@ToString
public class Project {
    private Integer id;
    private String name;
    private String sex;
    private Integer value;
    private Double weight;

    public Project() {
    }

    public Project(Integer id, String name, String sex,Integer value,Double weight) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.value =value;
        this.weight = weight;
    }
}
