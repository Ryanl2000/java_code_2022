package com.ryan.java;

import org.junit.Test;

import java.io.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/26
 */
public class ObjectTest {

    @Test
    public void test1() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));

            oos.writeObject(new Person("Tom", 18));

            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert oos != null;
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("obj.dat"));

            Object o = ois.readObject();

            Person p = (Person) o;

            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert ois != null;
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
