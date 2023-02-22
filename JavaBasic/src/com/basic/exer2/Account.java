package com.basic.exer2;

public class Account {
    private int id;
    private String pwd = "000000";
    private double balance;

    private static double interestRate;
    private static final double minMoney = 1.0;
    private static int init = 1001;

    public Account() {
        id = init++;
    }

    public Account(String pwd, double balance) {
        this.pwd = pwd;
        this.balance = balance;
        id = init++;
    }

    public int getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
