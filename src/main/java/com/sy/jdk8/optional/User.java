package com.sy.jdk8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/7 20:40
 * @Modified By:
 */
@Data
@AllArgsConstructor(staticName = "of")
public class User {
    private String name;

    private Integer age;

    public Optional<String> getPosition() {
        return Optional.ofNullable(name);
    }
}
