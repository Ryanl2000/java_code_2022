package com.ryan.java;

/**
 * @author RyanL
 * @description 多线程遍历100内的偶数
 * @create 2022/7/20
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread("我的线程一：");
        myThread.setPriority(10);
        myThread.start();
        Thread.currentThread().setName("主线程：");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
//                Thread.currentThread().sleep(1000);
                System.out.println(Thread.currentThread().getName() + i  + "优先级：" + Thread.currentThread().getPriority());
            }
            if (i == 50) {
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + i + "优先级：" + getPriority());
            }
            if (i == 50) {
                System.out.println(isAlive());
            }
        }
    }
}