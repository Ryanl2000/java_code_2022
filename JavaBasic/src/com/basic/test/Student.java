package com.basic.test;

public class Student extends Person {

    String major;
    String id = "1002";//学号
    static String job = "学生";

    public Student() {

    }

    public Student(String major) {
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void study() {
        System.out.println("学习的专业是：" + major);
    }

    @Override
    public void eat() {
        System.out.println("吃营养的食物");
    }

    public void show() {
        System.out.println("name = " + name + ", age = " + age + ", 学号 = " + id + ", 身份证号 = " + super.id);
    }

    public static String getJob() {
        return job;
    }

    public static void setJob(String job) {
        Student.job = job;
    }
}
