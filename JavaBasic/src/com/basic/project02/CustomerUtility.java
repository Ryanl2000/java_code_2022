package com.basic.project02;

import java.util.Scanner;

public class CustomerUtility {

    private static Scanner scan = new Scanner(System.in);

    private static String readKeyBoard(int limit, boolean blackEnter) {
        String line = "";
        while (scan.hasNext()) {
            line = scan.next();
            if (line.length() == 0){
                if (blackEnter) return line;
                else continue;
            }
            if (line.length() > limit) {
                System.out.println("输出长度不能大于" + limit + "请重新输入");
            } else {
                break;
            }
        }
        return line;
    }

    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("输入错误");
            } else {
                break;
            }
        }
        return c;
    }

    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return str.charAt(0);
    }

    public static int readInt() {
        int n;
        while (true) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("请重新输入");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue) {
        int n;
        while (true) {
            String str = readKeyBoard(2, false);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("请重新输入");
            }
        }
        return n;
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        if (str.equals("")) {
            return defaultValue;
        }
        return str;
    }

    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("请重新输入");
            }
        }
        return c;
    }
}
