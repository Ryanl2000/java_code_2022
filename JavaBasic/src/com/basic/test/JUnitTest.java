package com.basic.test;

import org.junit.Test;

public class JUnitTest {

    @Test
    public void testEquals() {
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
    }

    @Test
    public void anotherTest() {
        System.out.println("GG");
        Integer in1 = 10;
        double d = in1.doubleValue();
        int i = 5;
        String s = String.valueOf(i);
        System.out.println(d);

        String s1 = "145";
        double d1 = Double.parseDouble(s1);
        System.out.println(d1);
    }

    @Test
    public void test1() {
        Object o1 = true ? 1 : "111";
        System.out.println(o1);
    }

    @Test
    public void test2() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
    }
}