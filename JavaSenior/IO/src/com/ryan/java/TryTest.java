package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/25
 */
public class TryTest {

    public static void main(String[] args) {

        Number n = new Number(3);

        try {
            n.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("lalala");

    }
}

class Number {
    private int s;

    public Number(int s) {
        this.s = s;
    }

    public void show() throws Exception {
        if (s > 5) {
            System.out.println("OK");
            return;
        }
        throw new Exception("异常");
    }
}
