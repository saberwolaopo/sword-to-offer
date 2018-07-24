package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String []args){
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(5);
        for(int index = 0;index<20;index++){
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        semp.acquire();
                        System.out.println("Accessing: "+NO);
                        Thread.sleep((long)(Math.random()*10000));
//                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
