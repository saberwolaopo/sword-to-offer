package com.company.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class test_01 {
    public static class ThreadA extends Thread{
        private CyclicBarrier cbrdf;
        public ThreadA(CyclicBarrier cbrdf){
            super();
            this.cbrdf = cbrdf;
        }
        @Override
        public void run(){
            try{
                System.out.println(Thread.currentThread().getName()+"begin = "+System.currentTimeMillis()+"等待凑齐2个运动员开始比赛...");
                cbrdf.await();
                System.out.println(Thread.currentThread().getName()+"begin = "+System.currentTimeMillis()+"已经凑齐2个运动员开始比赛...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("leileleile~");
            }
        });
        for(int i = 0;i<4;i++){
            ThreadA threadA = new ThreadA(cyclicBarrier);
            threadA.start();
            Thread.sleep(2000);
        }
    }
}
