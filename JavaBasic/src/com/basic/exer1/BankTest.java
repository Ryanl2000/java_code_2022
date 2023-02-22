package com.basic.exer1;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("Jane", "Smith");
        bank.getCustomer(0).setAccount(new Account(1000));
        bank.getCustomer(0).getAccount().withdraw(500);

        bank.addCustomer("lin", "ryan");
        System.out.println(bank.getNumberOfCustomers());
        System.out.println(bank.getCustomer(1));

    }
}
