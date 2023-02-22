package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class Person {

    private String name;
    public int age;
    private static int gender = 0;

    public Person() {
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("我是一个人");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String showNation(String nation) {
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
