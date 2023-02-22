package com.ryan.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
public class LambdaTest {

    @Test
    public void test1() {

        Runnable r = () -> System.out.println("我是最棒的");

        r.run();

        Runnable r1 = () -> System.out.println("我是还行的");

        r1.run();

        Comparator<Integer> com = Integer::compare;

        Integer integer1 = 10;

        int compare = integer1.compare(1, 5);

        Consumer<String> con = System.out::println;

    }

    @Test
    public void test2() {

        Consumer<String> con = s -> System.out.println("我是谁");

        con.accept("sss");

    }

    @Test
    public void test3() {

        Function<Double, Long> fun = Math::round;

        System.out.println(fun.apply(1.55));

        String str1 = "adf";
        str1.compareTo("g");

    }

}
