package com.ryan.java;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * @author RyanL
 * @description
 * @create 2022/7/22
 */
public class EnumAndAnnotation {

    public static void main(String[] args) {
        GoodBefore honer = GoodBefore.HONER;
        System.out.println(honer);
        System.out.println("*********");
        Good good = Good.HUAWEI;
        System.out.println(good);

//        for (int i = 0; i < Thread.State.values().length; i++) {
//            System.out.println(Thread.State.values()[i]);
//        }

        System.out.println(Good.valueOf("HUAWEI"));


    }
}

enum Good implements Callable {
    HUAWEI("华为", "手机"),
    HONER("荣耀", "手机"),
    MI("小米", "手机"),
    IPHONE("苹果", "手机");

    private final String goodName;
    private final String goodDesc;

    Good(String goodName, String goodDesc) {
        this.goodName = goodName;
        this.goodDesc = goodDesc;
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}

@MyAnnotation
@MyAnnotation
class GoodBefore {

    private final String goodName;
    private final String goodDesc;

    private GoodBefore(String goodName, String goodDesc) {
        this.goodName = goodName;
        this.goodDesc = goodDesc;
    }

    public static final GoodBefore HUAWEI = new GoodBefore("华为", "手机");
    public static final GoodBefore HONER = new GoodBefore("荣耀", "手机");
    public static final GoodBefore MI = new GoodBefore("小米", "手机");
    public static final GoodBefore IPHONE = new GoodBefore("苹果", "手机");

    public String getGoodName() {
        return goodName;
    }

    @SuppressWarnings(value = {"unused"})
    public String getGoodDesc() {
        return goodDesc;
    }

    @Override
    public String toString() {
        return "GoodBefore{" +
                "goodName='" + goodName + '\'' +
                ", goodDesc='" + goodDesc + '\'' +
                '}';
    }

    public void go() {

    }
}

@Deprecated
interface Info {
    void show();
}

class AnnotationTest <@MyAnnotation T>{

    public void show () throws @MyAnnotation RuntimeException {

        ArrayList<String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;

    }
}
