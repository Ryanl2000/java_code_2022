package com.ryan.java;

import java.util.concurrent.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        System.out.println(executor.getClass());
//        executor.execute(new NewThread());

        NewThread1 newThread1 = new NewThread1();
        Future<Integer> f =  executor.submit(newThread1);
        try {
            Integer sum = f.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }


    }
}

class NewThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NewThread1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}
