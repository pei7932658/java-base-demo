package com.sy.jdk8.lambda;

import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2018/12/26 21:37
 * @Modified By:
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Project> list = listInit();

        //filter的效果，是将filter 条件中等于true的结果收集起来，并不是字面的意思filter掉到等于true的结果

        //将list 对象中属性sex=1的，对象找出来，并count 有多少个
//        System.out.println(list.stream().filter(project -> "1".equals(project.getSex())).count());;

        //将list 对象中属性sex=1的，对象找出来，并将其中一个属性ID作为key，然后转化成map
//        Map<Integer, Project> map = list.stream().filter(project -> "1".equals(project.getSex())).collect(Collectors.toMap(Project::getId, project -> project));
//        System.out.println(map);

         //将list 对象中属性sex=1的，对象找出来， 然后转化成一个新 list
//        List<Project> newList = list.stream().filter(project -> "1".equals(project.getSex())).collect(Collectors.toList());
//        System.out.println(newList);

        //将一个 List<Map> 中,某一个map，判断其中一个属性等于某值时去掉，然后再转化成一个新的List<Map>
//        List<Map<String,Object>> listMap = listMapInit();
//        List<Map<String,Object>> newListMap = listMap.stream().filter(m->{
//            AtomicBoolean filterB = new AtomicBoolean(true);
//            m.entrySet().stream().forEach(obj->{
////                System.out.println(obj.getKey()+":"+obj.getValue());
//                if("name".equals(obj.getKey()) && "peter".equals(obj.getValue())){
//                    filterB.set(false);
//                }
//            });
//            return filterB.get();
//        }).collect(Collectors.toList());
//        System.out.println(newListMap);

//        List<String> lists = new ArrayList<>();
//        lists.add("123");
//        lists.add(null);
//        lists.add("456");
//        System.out.println(lists.size());
//        List<String> list2 = lists.stream().filter(s-> !StringUtils.isEmpty(s)).collect(Collectors.toList());
//        System.out.println(list2);



//        ReadFile();

//        testFunction();


        /**
         * 把Lambda付诸实践：环绕执行模式  【https://cloud.tencent.com/developer/article/2020533】
         * 其中：br -> br.readLine() + "\r\n" + br.readLine()  是一个function 整个当作一个参数，传到BufferedReaderProcessor 接口中的process 里面去，相当于一个process的方法实现
         * Lambda表达式允许你直接内联，为函数式接口的抽象方法提供实现，并且将整个表达式作为函数式接口的一个实例。因此，可以在processFile主体内，对得到的BufferedReaderProcessor对象调用process方法执行处理：
         */
//        String result = procesFile(br -> br.readLine() ); //读一行
////        String result = procesFile(br -> br.readLine() + "\r\n" + br.readLine()); //读两行
//        System.out.println(result);

//        appleTest();

        methodUse();

        //将对象中的ID作为key，弄一个map 好判断对象合集中是否包含某个对应
//        Map<Integer,Project> mapPorject = list.stream().collect(Collectors.toMap(Project::getId,o->o));
//        Map<Integer,Project> mapPorject = list.stream().collect(Collectors.toMap(Project::getId,Function.identity()));
//        System.out.println(mapPorject);
    }

    public static List<Project> listInit() {
        List<Project> list = new ArrayList<Project>();
        Project p1 = new Project(1, "peter", "1");
        Project p2 = new Project(2, "hanmeimei", "0");
        Project p3 = new Project(3, "jonni", "1");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }

    public static List<Map<String, Object>> listMapInit() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "peter");
        map1.put("age", 2);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "peter2");
        map2.put("age", 3);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "peter3");
        map3.put("age", 3);
        list.add(map1);
        list.add(map2);
        list.add(map3);

        return list;
    }

    public static void ReadFile() {
        try {
            FileReader fr = new FileReader(new File("d:/data/1.txt"));
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine() + br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFunction() {
        Function<Integer, Integer> a = e -> e + 1;
        Function<Integer, Integer> b = e -> e * e;

//        System.out.println(calculate(a, 2));
//        System.out.println(calculate(b, 2));

        //下面两个运算效果一样，其中compose 就是函数里面传，函数，参数由里网外计算，相当于先算b，再算a
//        System.out.println(a.apply(b.apply(2)));
//        System.out.println(a.compose(b).apply(2));

        //下面两个运算效果一样，其中andThen，也是函数里面传函数，但参数是由网片里计算，相当于先算a，再算b
//        System.out.println(b.apply(a.apply(2)));
//        System.out.println(a.andThen(b).apply(2));
    }

    public static Integer calculate(Function<Integer, Integer> fc, Integer num) {
        return fc.apply(num);
    }

    //相当于在整个方法上面加了try catch
    @SneakyThrows
    public static String procesFile(BufferedReaderProcessor processor) {
        BufferedReader br = new BufferedReader(new FileReader("d:/data/sfhm.txt"));
        processor.doSomething("abc");
        return processor.process(br);
    }


    /**
     * 针对于List 不同条件的过滤，可以封装一个filterApples 方法，其中参数
     * --list
     * --IApplePredicate 接口；调用时传入的是方法的实现
     */
    public static void appleTest() {
        List<Apple> list = Arrays.asList(
                new Apple("red", 200),
                new Apple("green", 300),
                new Apple("green", 190));

        //使用方法一
        list = filterApples(list, new IApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                if ("green".equals(apple.getColor())
                        && apple.getWeight() > 200) {
                    return true;
                }
                return false;
            }
        });

        //使用方法二
        //后面方法是test实现，里面参数就是test里面的参数,返回结果要是test返回结果
//        list = filterApples(list, (Apple apple) -> {
//            if ("green".equals(apple.getColor())
//                    && apple.getWeight() > 200) {
//                return true;
//            }
//            return false;
//        });

        //使用方法三
        //更简单写法，直接传入参数，返回结果是什么即可
//        list = filterApples(list, apple -> "green".equals(apple.getColor()) && apple.getWeight() > 200);

        System.out.println(list);

        IApplePredicate filter1 = apple -> {
            System.out.println("");
            return "Green".equalsIgnoreCase(apple.getColor()) && 150 > apple.getWeight();
        };

        IApplePredicate filter = apple -> "green".equals(apple.getColor());
        System.out.println(filter.test(new Apple("green", 300)));
    }

    public static List<Apple> filterApples(List<Apple> apples, IApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        if (apples == null || apples.isEmpty()) {
            return result;
        }
        for (Apple a : apples) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    public static void methodUse() {
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();

        Function<String, Apple> f = Apple::new;
        Apple apply = f.apply("peter");
        System.out.println(apply);

        BiFunction<String, Integer, Apple> f1 = Apple::new;
        Apple apple1 = f1.apply("green", 200);
        System.out.println(apple1);
    }

}
