package com.ryan.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class ReflectionTest {

    @Test
    public void test1() throws Exception {

        Class<Person> personClass = Person.class;

//        personClass.newInstance();

        Constructor<Person> cons = personClass.getConstructor(String.class, int.class);

        Person tom = cons.newInstance("Tom", 12);

        System.out.println(tom);

        Field age = personClass.getDeclaredField("age");
        age.set(tom, 10);

        System.out.println(tom);

        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);

        Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);

        cons1.setAccessible(true);

        Person bob = cons1.newInstance("Bob");
        System.out.println(bob);

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(bob, "Tina");
        System.out.println(bob);

        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object o = showNation.invoke(bob, "China");
        String nation = (String) o;
        System.out.println(nation);


    }

    @Test
    public void test2() throws ClassNotFoundException {

        Class<Person> class1 = Person.class;
        System.out.println(class1);

        Person p = new Person();
        Class<? extends Person> class2 = p.getClass();
        System.out.println(class2);

        Class<?> class3 = Class.forName("com.ryan.java.Person");
        System.out.println(class3);

        System.out.println(class1 == class2);


    }

    @Test
    public void test3() {

        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.lang.String";
                break;
            case 1:
                classPath = "java.util.Date";
                break;
            case 2:
                classPath = "com.ryan.java.Person";
                break;
        }

        try {
            Object obj = newClass(classPath);
            System.out.println(num + "" + obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object newClass(String pathName) throws Exception {

        Class<?> aClass = Class.forName(pathName);
        return aClass.getDeclaredConstructor().newInstance();

    }

    @Test
    public void test4() throws Exception {

        Class<Person> personClass = Person.class;

        Person person = personClass.getDeclaredConstructor(String.class, int.class).newInstance("Ton", 15);

        Field gender = personClass.getDeclaredField("gender");

        gender.setAccessible(true);

        gender.set(null, 1);

        System.out.println(gender.get(person));


    }

}
