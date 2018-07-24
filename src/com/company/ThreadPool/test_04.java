package com.company.ThreadPool;

import java.util.HashSet;
import java.util.concurrent.*;

public class test_04 {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            try{
                System.out.println("begin  "+System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("end "+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args){
        LinkedBlockingDeque linked = new LinkedBlockingDeque<Runnable>();
        ArrayBlockingQueue array = new ArrayBlockingQueue<Runnable>(2);
        SynchronousQueue sync = new SynchronousQueue<Runnable>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS,sync);
        pool.execute(new MyRunnable());//1
        pool.execute(new MyRunnable());//2
        pool.execute(new MyRunnable());//3
//        pool.execute(new MyRunnable());//4
//        pool.execute(new MyRunnable());//5
//        pool.execute(new MyRunnable());//6
        System.out.println("核心池数量:"+pool.getCorePoolSize());
        System.out.println("线程池数量:"+pool.getPoolSize());
        System.out.println("队列长度:"+sync.size());
    }
}
