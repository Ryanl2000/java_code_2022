package com.ryan.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author RyanL
 * @description
 * @create 2022/7/22
 */
public class JDK8DateTest {

    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime.of(2021, Month.JANUARY, 15, 15, 0);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Instant instant = Instant.now();
        System.out.println(instant);
    }

    @Test
    public void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
        String s = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(s);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String s1 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(s1);
        System.out.println(dateTimeFormatter1.parse(s1));

    }

    @Test
    public void test3() {
        System.out.println();
    }
}
