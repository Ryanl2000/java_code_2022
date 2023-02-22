package com.ryan.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author RyanL
 * @description 存在线程安全问题待解决, 及线程安全的解决
 * @create 2022/7/20
 */
public class WindowTest {

    public static void main(String[] args) {

//        方法一
//        Window window1 = new Window();
//        Window window2 = new Window();
//        Window window3 = new Window();
//
//        window1.setName("窗口1");
//        window2.setName("窗口2");
//        window3.setName("窗口3");
//
//        window1.start();
//        window2.start();
//        window3.start();

//        方法二
        WindowRunnable windowRunnable = new WindowRunnable();
        Thread t1 = new Thread(windowRunnable);
        Thread t2 = new Thread(windowRunnable);
        Thread t3 = new Thread(windowRunnable);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

//        匿名方法
//        new Thread() {
//            private int ticket = 100;
//
//            @Override
//            public void run() {
//                while (true) {
//                    if (ticket > 0) {
//                        System.out.println(getName() + "卖票，票号为：" + ticket);
//                        ticket--;
//                    } else {
//                        break;
//                    }
//                }
//            }
//        };
    }
}

class Window extends Thread {

    private static int ticket = 100;
    private static boolean loopFlag = true;
//    private static final Object obj = new Object();

    @Override
    public void run() {
        while (loopFlag) {
            buyTicket();
        }
    }

    private static synchronized void buyTicket() {  //static后的锁为当前类
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        } else {
            loopFlag = false;
        }
    }
}

class WindowRunnable implements Runnable {
    private int ticket = 100;
//    private boolean loopFlag = true;
    private ReentrantLock lock = new ReentrantLock(true);
    //    final Object obj = new Object();

//    方法一
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
//            }
//        }
//    }

//    方法二
//    @Override
//    public void run() {
//        while (loopFlag) {
//            buyTickets();
//        }
//    }

//    private synchronized void buyTickets() {
//        if (ticket > 0) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
//            ticket--;
//        } else {
//            loopFlag = false;
//        }
//    }

//    方法三

    @Override
    public void run() {
        while (true) {
            try {
                // 调动lock方法
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}


