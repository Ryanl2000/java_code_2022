package com.ryan.java1;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
@MyAnnotation
public class Person extends Creature<String> implements Comparable<String> {

    private String name;
    int age;
    public int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @MyAnnotation("123")
    public Person(String gender, double weight, String name, int age, int id) {
        super(gender, weight);
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String myNation(String nation) {
        System.out.println(nation);
        return nation;
    }

    @Override
    public void breathe() {
        System.out.println("人可以呼吸");
    }

    @Override
    public void eat() {
        System.out.println("人可以吃饭");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
