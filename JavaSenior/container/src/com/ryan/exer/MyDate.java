package com.ryan.exer;

/**
 * @author RyanL
 * @description
 * @create 2022/7/23
 */
public class MyDate implements Comparable<MyDate>{

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        int subYear = year - o.year;
        if (subYear != 0)
            return subYear;
        int subMonth = month - o.month;
        if (subMonth != 0)
            return subMonth;
        return day - o.day;
     }
}
