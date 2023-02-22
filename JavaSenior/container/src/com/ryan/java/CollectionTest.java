package com.ryan.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


/**
 * @author RyanL
 * @description
 * @create 2022/7/22
 */
public class CollectionTest {
    public static void main(String[] args) {
        ArrayList coll = new ArrayList();
        ArrayList coll1 = new ArrayList();

        coll.add("AA");
        coll.add(123);
        coll.add(new Date());

        Collections.copy(coll1, coll);

        System.out.println(coll1);


    }
}
