package com.ryan.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");

        Date date = new Date();

        String format = sdf.format(date);

        System.out.println(format);

        String str = "29-6-7 24-15-6";

        Date parse = sdf.parse(str);

        System.out.println(parse);
    }
}
