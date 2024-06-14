package com.sy.lombok;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/9/25 13:57
 * @Modified By:
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)

public class Student {
    private Integer id;
    private String name;
    private Integer age;
}
