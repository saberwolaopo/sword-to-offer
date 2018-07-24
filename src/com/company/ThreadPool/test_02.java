package com.company.ThreadPool;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test_02 {
    public static class Myrunnable implements Runnable{
        private String username;
        public Myrunnable(String username){
            super();
            this.username = username;
        }
        public String getUsername(){
            return username;
        }

        @Override
        public void run() {
            for(int i = 0;i<Integer.MAX_VALUE/500;i++){
                String newString1 = new String();
                String newString5 = new String();
                String newString6 = new String();
                String newString7 = new String();
                Math.random();
                Math.random();
                Math.random();
            }
            System.out.println(Thread.currentThread().getName()+"任务完成!!!");
        }
    }
    public static void main(String []args){
        try{
            Myrunnable a1 = new Myrunnable("A1");
            Myrunnable a2 = new Myrunnable("A2");
            Myrunnable a3 = new Myrunnable("A3");
            Myrunnable a4 = new Myrunnable("A4");

            ThreadPoolExecutor pool = new ThreadPoolExecutor(2,10,30, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>());
            pool.execute(a1);
            pool.execute(a2);
            pool.execute(a3);
            pool.execute(a4);
            Thread.sleep(1000);

            List<Runnable> list = pool.shutdownNow();
            for(int i = 0;i<list.size();i++){
                Myrunnable myrunnable = (Myrunnable) list.get(i);
                System.out.println(myrunnable.getUsername()+"任务被取消!!!");
            }
            System.out.println("main end!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
