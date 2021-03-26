package com.sy.jdk8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/1/4 14:46
 * @Modified By:
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;

    default void doSomething(String m){
        System.out.println(m.toUpperCase());
    }
}
