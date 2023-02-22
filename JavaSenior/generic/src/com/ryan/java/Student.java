package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/24
 */
public class Student extends Person{

    private int id;
    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
