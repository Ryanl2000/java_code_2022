package com.basic.exer2;

public class AccountTest {

    public static void main(String[] args) {
        Account acc1 = new Account();
        Account acc2 = new Account("123456", 1000);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(Account.getInterestRate());
    }
}
