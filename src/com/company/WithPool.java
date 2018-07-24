package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithPool {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Callable<Object>> list = new ArrayList<Callable<Object>>();
        for(int i = 0;i<3;i++){
            list.add(new ChildThread(i));
        }
        try{
            pool.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        System.out.println("Main Finished!");
    }
    private static class ChildThread implements Callable<Object> {
        private  int id;

        public ChildThread(int id) {
            this.id=id;
        }
        public Object call(){
            try{
                Thread.sleep(Math.abs(new Random().nextInt(5000)));
                System.out.println(String.format("Child Thread %d finished", id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
