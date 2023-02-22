package com.ryan.java1;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
public class Creature<T> {

    private String gender;
    public double weight;

    public Creature(String gender, double weight) {
        this.gender = gender;
        this.weight = weight;
    }

    public Creature() {
    }

    public void breathe() {
        System.out.println("breathe");
    }

    public void eat() {
        System.out.println("eat");
    }

}
