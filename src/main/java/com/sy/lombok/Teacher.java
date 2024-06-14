package com.sy.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/9/25 13:57
 * @Modified By:
 * @Version: 1.0
 */
@Data
@Builder
public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
}
