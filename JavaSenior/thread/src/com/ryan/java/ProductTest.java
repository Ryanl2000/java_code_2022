package com.ryan.java;

/**
 * @author RyanL
 * @description
 * @create 2022/7/20
 */
public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Thread p1 = new Thread(producer);
        p1.setName("生产者1");

        Customer customer = new Customer(clerk);
        Thread c1 = new Thread(customer);
        Thread c2 = new Thread(customer);
        c1.setName("消费者1");
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();

    }
}

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始生产产品....");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}


class Customer implements Runnable {

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始消费产品....");
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

class Clerk {

    private int productNum = 0;

    public synchronized void produceProduct() {
        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "：开始生成第" + productNum + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consumeProduct() {
        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productNum + "个产品");
            productNum--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}