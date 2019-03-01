package com.megvii.sng.dzh.codesample.singleton.lombok;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/4 15:20
 * @Modified By:
 */
public class LomBokTest {
    public static void main(String[] args) {
        User u = User.of("peter","1",23);
        System.out.println(u);


        //User u2 = new User(null,"1",23);

        //User u3 = new User();

        User u4 = User.name("peter");
        System.out.println(u4);
    }
}
