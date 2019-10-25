package com.sy.spring4_2.utils;

import com.sy.desginer.prototype.Prototype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/10/16 14:11
 * @Modified By:
 */
public class BeanUtilsTest {
    public static void main(String[] args) {
        User resource = User.of(1, "peiliang", "湖北武汉", Car.of("white"), Arrays.asList("abc"));

        User target = new User();

        //浅复制
//        BeanUtils.copyProperties(resource,target);

        //深复制
//        target = (User) CommonUtils.deeplyCopy(resource);

        try {
            target = resource.deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        target.setUserName("peter");//值引用

        //指针引用
        target.getCar().setColor("black");
        target.getList().set(0, "123");


        System.out.println("source: " + resource);
        System.out.println("target: " + target);

    }
}

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@ToString
class User implements Serializable {

    private static final long serialVersionUID = 404328039793848974L;

    private Integer userId;
    private String userName;
    private String address;
    private Car car;
    private List<String> list;

    //深复制
    public User deepClone() throws IOException, ClassNotFoundException {
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        oos.close();
        bos.close();
        return (User) ois.readObject();
    }
}

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@ToString
class Car implements Serializable {
    private static final long serialVersionUID = 8721357064260474167L;

    private String color;
}
