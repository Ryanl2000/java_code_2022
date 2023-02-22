package com.ryan.java;

import java.util.Calendar;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, 15);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
    }
}
