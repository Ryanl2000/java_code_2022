package com.ryan.exer1;

/**
 * @author RyanL
 * @description
 * @create 2022/7/20
 */
public class AccountTest {

    public static void main(String[] args) {
        Account acc = new Account(0);
        Customer customer = new Customer(acc);
        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}

class Account {
    private double balance;
//    private static ReentrantLock lock = new ReentrantLock(true);

    public Account(double balance) {
        this.balance = balance;
    }

//    public void addBalance(double money) {
//        try {
//            if (money > 0) {
//                lock.lock();
//                balance += money;
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "存钱成功。当前余额为" + balance);
//            }
//        } finally {
//            lock.unlock();
//        }
//    }

    public synchronized void addBalance(double money) {
        if (money > 0) {
            balance += money;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功。当前余额为" + balance);
        }
    }
}

class Customer implements Runnable {

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.addBalance(1000);
        }
    }
}
