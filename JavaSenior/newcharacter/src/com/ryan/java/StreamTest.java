package com.ryan.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
public class StreamTest {

    @Test
    public void test1() {

        IntStream stream = Arrays.stream(new int[5]);
        String[] strs = new String[]{"aa","bb"};
        Stream<String> strs1 = Stream.of(strs);


    }

    @Test
    public void test() {

//        Stream.iterate(0, t -> t + 2).limit(10);

        List<String> list = Arrays.asList("aa", "bb", "cc");

        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println();

        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest::fromStringToStream);
        streamStream.forEach(characterStream -> {
            characterStream.forEach(System.out::println);
        });

        System.out.println();

        Stream<Character> characterStream = list.stream().flatMap(StreamTest::fromStringToStream);
        characterStream.forEach(System.out::println );


    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();


    }


    @Test
    public void test3() {
        Person p1 = new Person(12);
        Person p2 = new Person(13);
        Person p3 = new Person(20);

        ArrayList<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);

        list.forEach(System.out::println);

        list.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
    }

}
