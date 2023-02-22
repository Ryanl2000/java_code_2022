package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class StringTest {
    public static void main(String[] args) {

        char[] c = new char[]{'a', 'b', 'c', 'd', 'e'};

        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = new String(c, 2, 2);
//        s1 = "def";
        String s4 = s1.intern();

        System.out.println(s4);
    }


}
