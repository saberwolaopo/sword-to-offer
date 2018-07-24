package com.company.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test_03 {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"begin"+System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"end"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []argv) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,99999,99999, TimeUnit.SECONDS
        ,new LinkedBlockingQueue<Runnable>());

        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);

        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());
        pool.shutdown();
        Thread.sleep(1000);
        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating()+"---"+pool.isTerminated());


    }
}
