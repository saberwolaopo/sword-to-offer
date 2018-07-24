package com.company.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test_01 {
    public static void main(String []args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName()+"run!"+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,10,5,
                TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        executor.execute(runnable);//1
        executor.execute(runnable);//2
        executor.execute(runnable);//3
        executor.execute(runnable);//4
        executor.execute(runnable);//5
        executor.execute(runnable);//6
        executor.execute(runnable);//7
        executor.execute(runnable);//8
        executor.execute(runnable);//9

        Thread.sleep(300);

        System.out.println("A---核心池数量:"+executor.getCorePoolSize());
        System.out.println("A---线程池数量:"+executor.getPoolSize());
        System.out.println("A---线程队列长度"+executor.getQueue().size());

        Thread.sleep(10000);

        System.out.println("B---核心池数量:"+executor.getCorePoolSize());
        System.out.println("B---线程池数量:"+executor.getPoolSize());
        System.out.println("B---线程队列长度"+executor.getQueue().size());
    }
}
