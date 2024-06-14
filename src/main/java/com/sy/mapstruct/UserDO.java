package com.sy.mapstruct;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/10/8 14:36
 * @Modified By:
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class UserDO {
    /** 用户编号 **/
    private Integer id;
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;

    /** 性别命名不一样 **/
    private String sexType;
}
