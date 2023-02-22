package com.ryan.java;

import com.ryan.exer.Employee;
import com.ryan.exer.MyDate;
import org.junit.Test;

import java.util.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/23
 */
public class ListSetTest {

    @Test
    public void testList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(11);
        list.add("adf");
        list.remove(Integer.valueOf(11));
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testSet() {
        HashSet<Object> set = new HashSet<>();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Bob", 12));
        set.add(new Person("Bob", 12));
        set.add(129);
        for (Object obj : set) {
            System.out.println(obj);
        }

    }

    @Test
    public void testTreeSet() {
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(11);
//        set.add(-11);
//        set.add(15);
//        set.add(18);
//        set.add(-25);
//        set.add(60);
//        for (int i : set) {
//            System.out.println(i);
//        }
        TreeSet<Person> set1 = new TreeSet<>();
        set1.add(new Person("Tom", 12));
        set1.add(new Person("Bob", 15));
        set1.add(new Person("Tina", 12));
        set1.add(new Person("Tay", 20));
        set1.add(new Person("Jack", 18));
        set1.add(new Person("Tina", 15));
        for (Person p : set1) {
            System.out.println(p);
        }
    }

    @Test
    public void TestMyDate() {

        TreeSet<Employee> set = new TreeSet<>();

        Employee e1 = new Employee("Tom", 18, new MyDate(2000, 1, 1));
        Employee e2 = new Employee("Tina", 19, new MyDate(1999, 8, 6));
        Employee e3 = new Employee("Jack", 18, new MyDate(2000, 1, 5));
        Employee e4 = new Employee("Jim", 18, new MyDate(2000, 7, 9));
        Employee e5 = new Employee("Bob", 20, new MyDate(2000, 1, 18));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        System.out.println(set.toString());
        for (Object e : set) {
            System.out.println(e);
        }


    }
}
