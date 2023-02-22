package com.ryan.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RyanL
 * @description
 * @create 2022/7/24
 */
public class Order<T> {

    private String name;
    private int age;
    private T orderT;

    public Order() {
    }

    public Order(String name, int age) {
        this.name = name;
        this.age = age;
//        this.orderT = orderT;
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

    public T getOrderT() {
        return orderT;
    }

    public <E> List<E> show(E[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
