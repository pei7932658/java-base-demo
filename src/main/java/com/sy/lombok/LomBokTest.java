package com.sy.lombok;

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

        //链式编程
        Student student = new Student().setId(1).setName("peter").setAge(12);
        Teacher teacher = Teacher.builder().id(2).name("张三").age(32).build();
        System.out.println(student);
        System.out.println(teacher);
    }
}
