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
public class RoleDO {
    /** 用户编号 **/
    private Integer id;
    /** 用户名 **/
    private String rolename;

}
