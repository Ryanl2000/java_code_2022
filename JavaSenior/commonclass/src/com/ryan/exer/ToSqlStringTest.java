package com.ryan.exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class ToSqlStringTest {

    public static void main(String[] args) throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birth);

        long time = parse.getTime();
        java.sql.Date date = new java.sql.Date(time);
        System.out.println(date);
    }
}
