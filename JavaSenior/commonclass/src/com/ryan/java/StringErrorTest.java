package com.ryan.java;

import org.junit.Test;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class StringErrorTest {

    @Test
    public void test1() {

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());
        System.out.println(sb);
//        System.out.println(str.length());

//        StringBuffer sb1 = new StringBuffer(str);
//        System.out.println(sb1);
    }

    @Test
    public void test2() {
        int[] ints = new int[0];

        System.out.println(ints.length);

    }

    @Test
    public void test3() {
        int i = 50, j = 6;
        System.out.println(i / j);
    }
}
