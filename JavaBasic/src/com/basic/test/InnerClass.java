package com.basic.test;

public class InnerClass {

    public void method() {
        int num = 10;

        class AA {

            public void show() {
//                num = 20;
                System.out.println(num);
            }
        }
    }
}
