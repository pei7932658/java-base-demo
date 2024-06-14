package com.sy.mapstruct;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/10/8 17:20
 * @Modified By:
 * @Version: 1.0
 */
public class UserBOTest {
    public static void main(String[] args) {
        // 创建 UserDO 对象
        UserDO userDO = new UserDO()
                .setId(1).setUsername("yudaoyuanma").setPassword("buzhidao").setSexType("1");
        // 进行转换
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO);


        UserDO userDO2 = new UserDO()
                .setId(2).setUsername("yudaoyuanma2").setPassword("buzhidao2").setSexType("3");
        RoleDO roleDO2 = new RoleDO()
                .setId(3).setRolename("roleName");
        UserBO userBO2 = UserConvert.INSTANCE.convert(userDO2,roleDO2);
        System.out.println(userBO2.toString());
    }
}
