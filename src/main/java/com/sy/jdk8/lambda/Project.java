package com.sy.jdk8.lambda;

import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2018/12/26 21:41
 * @Modified By:
 */
@Data
public class Project {
    private int id;
    private String name;
    private String sex;

    public Project() {
    }

    public Project(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
