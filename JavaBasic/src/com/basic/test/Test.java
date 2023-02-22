package com.basic.test;

/**
 * @author RyanL
 * @version 1.0.1
 */

import java.lang.NumberFormatException;

public class Test {

    public static void method1() throws NumberFormatException {

        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);

    }

    public static void method2() throws RuntimeException {
        method1();
    }

    public static boolean method() {
        int[] m = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < m.length; i++) {
//            return m[i] == 4;
            if (m[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(method());

    }

}

class Student1 {

    private int id;

    public void setId(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            throw new MyException("输入数据有误");
        }
    }

    public int getId() {
        return id;
    }
}







