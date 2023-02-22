package com.basic.test;

public class Marry {
    public static void main(String[] args) {
        Boy b1 = new Boy();
        Boy b2 = new Boy();
        Girl g1 = new Girl();
        Girl g2 = new Girl();

        b1.setAge(21);
        b1.setName("小帅");
        b2.setAge(23);
        b2.setName("小王");

        g1.setAge(22);
        g1.setName("小丽");
        g2.setAge(23);
        g2.setName("小华");

        b1.marry(g1);
        b2.marry(g1);

        g1.marry(b2);
        g2.marry(b1);
    }
}

class Boy {
    private int age;
    private String name;

    public Boy() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry(Girl girl) {
        if (age >= 22) {
            System.out.println("我想娶" + girl.getName());
        }
    }
}

class Girl {
    private int age;
    private String name;

    public Girl() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry(Boy boy) {
        System.out.println("我要嫁给" + boy.getName());
        boy.marry(this);
    }
}