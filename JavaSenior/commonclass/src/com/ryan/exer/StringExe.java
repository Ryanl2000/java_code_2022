package com.ryan.exer;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class StringExe {

    String str = new String("good");
    char[] c = {'t','e','s','t'};

    public void change(String str, char[] c) {
        str = "test ok";
        c[0] = 'b';
    }

    public static void main(String[] args) {
        StringExe s = new StringExe();
        s.change(s.str, s.c);
        System.out.println(s.str);
        System.out.println(s.c);
    }
}
