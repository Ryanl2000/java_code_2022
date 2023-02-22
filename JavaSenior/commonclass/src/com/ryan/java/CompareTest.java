package com.ryan.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RyanL
 * @description
 * @create 2022/7/22
 */
public class CompareTest {

    @Test
    public void test1() {
        Good[] goods = new Good[4];
        goods[0] = new Good("Mi", 1000);
        goods[1] = new Good("Lenovo", 1200);
        goods[2] = new Good("HW", 1500);
        goods[3] = new Good("HP", 1200);

        Arrays.sort(goods);

        for (Good good : goods) {
            System.out.println(good);
        }
    }

    @Test
    public void test2() {
        String[] arr = {"AA", "BB", "DD", "GG", "CC", "EE", "MM", "LL"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(System.getProperty("java.version"));
    }
}

class Good implements Comparable {
    private String name;
    private double price;

    public Good() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Good) {
            Good good = (Good) o;
            if (this.price > good.price) {
                return 1;
            } else if (this.price < good.price) {
                return -1;
            } else {
                return this.name.compareTo(good.name);
            }
        }
        throw new RuntimeException("传入数据类型不一致");
//        Double.compare();
    }
}
