package com.company;

import java.util.ArrayList;
import java.util.List;

public class CopyOnWriteArrayList {
//    public static List list = new ArrayList();
      public static List list = new java.util.concurrent.CopyOnWriteArrayList();
    public static class ThreadA extends Thread {
        @Override
        public void run(){
            for(int i = 0;i<100;i++){
                list.add("something just like this~");
            }
        }
    }
    public static void main(String []args) throws InterruptedException {
        ThreadA []array = new ThreadA[100];
        for(int i = 0;i<array.length;i++){
            array[i] = new ThreadA();
        }
        for(int i = 0;i<array.length;i++){
            array[i].start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
