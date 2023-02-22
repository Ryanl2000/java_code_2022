package com.ryan.java;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author RyanL
 * @description
 * @create 2022/7/23
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 42L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Person) {
//            Person p = (Person) o;
//            int compare = this.name.compareTo(p.name);
//            if (compare == 0) {
//                return Integer.compare(this.age, p.age);
//            } else {
//                return compare;
//            }
//        }
//        throw new RuntimeException("类型不一致");
//    }
}
