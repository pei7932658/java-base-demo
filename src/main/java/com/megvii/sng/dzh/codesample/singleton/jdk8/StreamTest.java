package com.megvii.sng.dzh.codesample.singleton.jdk8;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2018/12/29 17:43
 * @Modified By:
 */
public class StreamTest {


    public static void main(String[] args) {
        List<PersonModel> list = getData();
        List<PersonModel> newList = new ArrayList<PersonModel>();

        //old method
//        for (PersonModel m : list) {
//            if (m.getSex().equals("男")) {
//                newList.add(m);
//            }
//        }

        //-------------------------------------------------------filter new-------------------------------------------------------//
//        List<PersonModel> temList = newList.stream().filter(person -> "男".equals(person.getSex())).filter(person -> person.getAge() >= 20).collect(Collectors.toList());
//        System.out.println(temList.size());

        //-------------------------------------------------------map-------------------------------------------------------//
//        List<String> collect = list.stream().map(p ->p.getEnName()).collect(Collectors.toList());
//        System.out.println(collect);
//
//        List<String> collect1 = list.stream().map(PersonModel::getEnName).collect(Collectors.toList());
////        System.out.println(collect1);

//        List<String> collect2 = list.stream().map(p ->{
//            System.out.println(p.getEnName());
//            return p.getEnName();
//        }).collect(Collectors.toList());
//        System.out.println(collect2);


        //-------------------------------------------------------flatMap-------------------------------------------------------//
//        System.out.println( Arrays.stream(list.get(0).getEnName().split(" ")).count() );
//        System.out.println( list.stream().map(p->Arrays.stream(p.getEnName().split(" "))).count() );

//        List<String> collect3 = list.stream().flatMap(p -> Arrays.stream(p.getEnName().split(" "))).collect(Collectors.toList());
//        System.out.println(collect3);

//        List<Stream<String>> collect4 = list.stream().map(p -> Arrays.stream(p.getEnName().split(" "))).collect(Collectors.toList());
//        List<String> list1 = new ArrayList<String>();
//        for (Stream<String> stream : collect4) {
//            list1.addAll(stream.collect(Collectors.toList()));
//        }
//        System.out.println(list1);
//
//        List<String> collect5 = list.stream().map(p -> p.getEnName().split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
//        System.out.println(collect5);
        //另一种方式
//        List<String> collect6 = list.stream()
//                .map(p -> p.getEnName().split(" "))
//                .flatMap(str -> Arrays.asList(str).stream()).collect(Collectors.toList());
//
//
//        String s[] = new String[]{"1", "2", "3"};
//
//        List<String> list2 = Arrays.stream(s).collect(Collectors.toList());
//        System.out.println(list2);

//
//        List<String> collect4 = list.stream().map(p ->p.getEnName().split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
//        List<String> collect5 = list.stream().map(p ->p.getEnName().split(" ")).flatMap(str->Arrays.asList(str).stream()).collect(Collectors.toList());
//        System.out.println(collect4);

        //collect
//        Map<String,Integer> map = list.stream().collect(Collectors.toMap(PersonModel::getEnName,PersonModel::getAge));
//        System.out.println(map);


        //-------------------------------------------------------reduce-------------------------------------------------------//
//        Integer reduce =  Stream.of(1,2,3,4).reduce(10,(count,item)->{
//            System.out.println("count:"+count+",item:"+item);
//            return count + item;
//        });
//        System.out.println(reduce);
//        List<String>list1 = Stream.of("a","b","c").collect(Collectors.toList());
//        System.out.println(list1);

        //-------------------------------------------------------collect-------------------------------------------------------//
//        Map<Boolean, List<PersonModel>> collect = list.stream().collect(Collectors.groupingBy(p -> "女".equals(p.getSex())));
//        System.out.println(collect);
//
//        String names = list.stream().map(PersonModel::getEnName).collect(Collectors.joining(",", "{", "}"));
//        System.out.println(names);
//
//        List<String> collect1 = Stream.of("1", "2", "3").collect(Collectors.reducing(
//                new ArrayList<String>(), x -> Arrays.asList(x), (y, z) -> {
//                    y.addAll(z);
//                    return y;
//                }
//        ));

        //-------------------------------------------------------optional-------------------------------------------------------//
        PersonModel p = new PersonModel();
        Optional<PersonModel> o = Optional.of(p);
        System.out.println(o.isPresent()?o.get():"-");

        Optional<String> name = Optional.ofNullable(p.getEnName());
        System.out.println(name.isPresent()?name.get():"-");

        Optional.ofNullable("test").ifPresent(na->{
            System.out.println(na+" ifPresent");
        });

        System.out.println(Optional.ofNullable(null).orElse("-"));
        System.out.println(Optional.ofNullable("1").orElse("-"));

        boolean b = Optional.ofNullable(p).map(PersonModel::getEnName).isPresent();
        System.out.println(b);

    }

    public static List<PersonModel> getData() {
        PersonModel wu = new PersonModel("wu qi", 18, "男");
        PersonModel zhang = new PersonModel("zhang san", 19, "男");
        PersonModel wang = new PersonModel("wang si", 20, "女");
        PersonModel zhao = new PersonModel("zhao wu", 20, "男");
        PersonModel chen = new PersonModel("chen liu", 21, "男");
        return Arrays.asList(wu, zhang, wang, zhao, chen);
    }

}

class PersonModel {
    private String enName;

    private Integer age;

    private String sex;

    public PersonModel() {
    }

    public PersonModel(String enName, Integer age, String sex) {
        this.enName = enName;
        this.age = age;
        this.sex = sex;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "enName='" + enName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
