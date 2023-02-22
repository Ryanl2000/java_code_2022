package com.basic.test;


public class Person {

    String name;
    int age;
    String id = "140602";//身份证号
    static String desc = "我";

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("我是一个快乐的人");
    }

    {
        desc = "My";
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public void walk(int distance) {
        System.out.println("走路的公里数为：" + distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && id.equals(person.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}
