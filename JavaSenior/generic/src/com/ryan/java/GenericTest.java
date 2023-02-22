package com.ryan.java;

import org.junit.Test;

import java.util.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/24
 */
public class GenericTest {

    @Test
    public void test1() {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(78);
        list.add(79);
        list.add(100);

//        list.add("Tom");
//        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

    }

    @Test
    public void test2() {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("12",13);

        Integer integer = hashMap.get("12");

        System.out.println(integer);

        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + " ---> " + value);
        }

        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<String> list = order.show(new String[5]);

        System.out.println(list);

    }

    @Test
    public void test3() {

        ArrayList<String> list1 = new ArrayList<>(10);

        list1.add("AA");
        list1.add("AA");
        ArrayList<?> list = null;

        list = list1;
        Object o = list.get(0);
        System.out.println(o);


    }

}
