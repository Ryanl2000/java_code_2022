package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class StringBufferBuilder {

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        System.out.println(s1.length());
        s1.append(1);
        s1.append("abc");
        System.out.println(s1);
        String substring = s1.substring(1, 2);
        s1.setCharAt(1, '4');
        System.out.println(s1);


    }
}
