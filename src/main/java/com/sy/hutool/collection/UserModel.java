package com.sy.hutool.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/9/22 15:31
 * @Modified By:
 * @Version: 1.0
 */
@Data
@AllArgsConstructor(staticName="of")
public class UserModel {
    private Integer id;
    private String userName;
}
