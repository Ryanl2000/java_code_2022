package com.ryan.java;

import org.junit.Test;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class StringMethod {

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        String s2 = "   hello w    world   ";
        String s3 = "adf";
        String s4 = "abf";

        System.out.println(s1.length());
        System.out.println(s1.charAt(1));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println("------" + s2 + "------");
        System.out.println("------" + s2.trim() + "------");
        System.out.println(s4.compareTo(s3));

    }
}
