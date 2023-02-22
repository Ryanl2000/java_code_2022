package com.ryan.java1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author RyanL
 * @description
 * @create 2022/7/28
 */
public class ReflectTest {

    @Test
    public void fieldTest() {

        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getFields();

        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("***********************************");
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field f : declaredFields) {
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            String name = f.getName();
            System.out.print(name);

            System.out.println();
        }
    }

    @Test
    public void methodTest() {

        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();

        for (Method m : methods) {
            System.out.println(m);
        }

    }

}
