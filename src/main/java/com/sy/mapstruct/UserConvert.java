package com.sy.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * build时会生成UserConvertImpl.class 文件
 */

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * 在对象转换时，我们可能会存在属性不是完全映射的情况，例如说属性名不同。此时，我们可以使用 MapStruct 提供的 @Mapping 注解，配置相应的映射关系。
     */
    @Mappings(
            @Mapping(source = "sexType", target = "sex")
    )
    UserBO convert(UserDO userDO);

    /**
     * 可以多个对象转换成一个
     * @param userDO
     * @param roleDO
     * @return
     */

    @Mappings(
            value = {
                    @Mapping(source = "userDO.id", target = "id"),
                    @Mapping(source = "userDO.username", target = "username"),
                    @Mapping(source = "userDO.password", target = "password"),
                    @Mapping(source = "userDO.sexType", target = "sex"),
                    @Mapping(source = "roleDO.id", target = "roleId"),
                    @Mapping(source = "roleDO.rolename", target = "rolename")
            }
    )
    UserBO convert(UserDO userDO, RoleDO roleDO);
}
