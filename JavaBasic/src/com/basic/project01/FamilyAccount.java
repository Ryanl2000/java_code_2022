package com.basic.project01;

/**
 * @author RyanL
 * @version 1.0.1
 */
public class FamilyAccount {
    public static void main(String[] args) {
        String detail = "收支\t账户金额\t收支金额\t说    明\n";
        int balance = 10000;
        label : while (true) {
            System.out.println("\n-----------------家庭收支记账软件-----------------\n");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退    出\n");
            System.out.print("                   请选择(1-4)：");

            char key = Unity.readMenuSelection();
            switch (key) {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(detail);
                    break;
                case '2':
                    System.out.println("请输入收入金额");
                    int addNum = Unity.readNumber();
                    System.out.println("请输入收入说明");
                    String addDetail = Unity.readString();

                    balance += addNum;
                    detail += "收入\t" + balance + "\t\t" + addNum + "\t\t" + addDetail + "\n";
                    break;
                case '3':
                    System.out.println("请输入支出金额");
                    int minusNum = Unity.readNumber();
                    System.out.println("请输入支出说明");
                    String minusDetail = Unity.readString();

                    balance += minusNum;
                    detail += "收入\t" + balance + "\t\t" + minusNum + "\t\t" + minusDetail + "\n";
                    break;
                case '4':
                    System.out.println("请确认是否退出（Y/N）：");
                    char exit = Unity.readConfirmSelection();
                    if (exit == 'Y') {
                        break label;
                    }
            }
        }
    }
}
