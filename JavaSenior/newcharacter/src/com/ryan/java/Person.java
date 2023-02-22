package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
public class Person {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
