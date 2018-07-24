package com.company.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class test_01 {
    public static void main(String []args){
        try{
            ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
            queue.put("a1");
            queue.put("a2");
            queue.put("a3");
            System.out.println(queue.size());
            System.out.println(System.currentTimeMillis());
            queue.put("a4");
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
