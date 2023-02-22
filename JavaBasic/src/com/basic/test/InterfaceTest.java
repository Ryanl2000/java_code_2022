package com.basic.test;

public class InterfaceTest implements Flyable {

    public static void main(String[] args) {
        System.out.println(Flyable.MIN_SPEED);
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.fly();

        Flyable flyable = new Flyable() {
            @Override
            public void fly() {
                System.out.println();
            }
        };
    }

    @Override
    public void fly() {
        System.out.println(Flyable.MAX_SPEED);
    }

}

interface Flyable {

    int MAX_SPEED = 7900;
    int MIN_SPEED = 1;

    void fly();

}

interface FlyTest {

    public static void method1() {
        System.out.println("method1");
    }

    public default void method2() {
        System.out.println("method2");
    }
}

