package com.basic.project01;

import java.util.*;

public class Unity {
    private static Scanner scan = new Scanner(System.in);
    /**
     * 用于读取限制字符数量的键盘输入
     */
    private static String readKeyBoard(int limit) {
        String line = "";
        while (scan.hasNext()) {
            line = scan.next();
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输出长度不能大于" + limit + "请重新输入");
            } else {
                break;
            }
        }
        return line;
    }

    /**
     * 用于选择菜单栏选项
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("选择错误，请重新输入");
            } else {
                break;
            }
        }
        return c;
    }

    public static int readNumber() {
        int num;
        while (true) {
            String str = readKeyBoard(4);
            try {
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入有误，请重新输入");
            }
        }
        return num;
    }

    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }

    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("输入错误，请重新输入");
            }
        }
        return c;
    }
}
