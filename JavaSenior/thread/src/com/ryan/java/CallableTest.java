package com.ryan.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author RyanL
 * @description
 * @create 2022/7/21
 */
public class CallableTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();

        FutureTask<Integer> futureTask = new FutureTask<>(myThread1);

        new Thread(futureTask).start();

        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class MyThread1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
