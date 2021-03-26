package com.sy.jdk8.lambda;

import lombok.SneakyThrows;

import java.io.*;
import java.util.*;
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
        List<Project> list  = listInit();
        Map<Integer,Project> map=null;
//        System.out.println(list.stream().filter(project -> "1".equals(project.getSex())).count());;
        map=list.stream().filter(project -> "1".equals(project.getSex())).collect(Collectors.toMap(Project::getId,project->project));
        System.out.println(map.size());

//        ReadFile();
//        testFunction();


//        String result = procesFile(br -> br.readLine() + "\r\n" + br.readLine());

//        appleTest();
//        methodUse();
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

        System.out.println(calculate(a, 2));
        System.out.println(calculate(b, 2));

        System.out.println(a.apply(b.apply(2)));
        System.out.println(a.compose(b).apply(2));

        System.out.println(b.apply(a.apply(2)));
        System.out.println(a.andThen(b).apply(2));
    }

    public static Integer calculate(Function<Integer, Integer> fc, Integer num) {
        return fc.apply(num);
    }

    //相当于在整个方法上面加了try catch
    @SneakyThrows
    public static String procesFile(BufferedReaderProcessor processor) {
        BufferedReader br = new BufferedReader(new FileReader("d:/data/12.txt"));
        processor.doSomething("abc");
        return processor.process(br);
    }


    public static void appleTest() {
        List<Apple> list = Arrays.asList(
                new Apple("red", 200),
                new Apple("green", 300),
                new Apple("green", 190));

//        list = filterApples(list, new IApplePredicate() {
//            @Override
//            public boolean test(Apple apple) {
//                if ("green".equals(apple.getColor())
//                        && apple.getWeight() > 200) {
//                    return true;
//                }
//                return false;
//            }
//        });
        //后面方法是test实现，里面参数就是test里面的参数,返回结果要是test返回结果
        list = filterApples(list, (Apple apple) -> {
            if ("green".equals(apple.getColor())
                    && apple.getWeight() > 200) {
                return true;
            }
            return false;
        });

        //更简单写法，直接传入参数，返回结果是什么即可
        list = filterApples(list, apple -> "green".equals(apple.getColor()) && apple.getWeight() > 200);

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

    public static void methodUse(){
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();

        Function<String,Apple> f = Apple::new;
        Apple apply = f.apply("peter");
        System.out.println(apply);

        BiFunction<String,Integer,Apple> f1= Apple::new;
        Apple apple1 = f1.apply("green",200);
        System.out.println(apple1);
    }

}
