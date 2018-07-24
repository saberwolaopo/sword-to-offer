package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer3 {
    public static class Producer implements Runnable{
        final BlockingQueue  sharequeue;

        public Producer(BlockingQueue sharequeue) {
            this.sharequeue = sharequeue;
        }

        public void run() {
            for(int i = 0;i<10;i++){
                try{
                    System.out.println("生产："+i);
                    sharequeue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Consumer implements Runnable{
        final BlockingQueue  sharequeue;

        public Consumer(BlockingQueue sharequeue) {
            this.sharequeue = sharequeue;
        }

        public void run() {
            while(true){
                try{
                    int i = (int) sharequeue.take();
                    System.out.println("消费: "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String []args){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(1);
        BlockingQueue shareQueue = new LinkedBlockingQueue();
        Thread prodThread = new Thread(new Producer(shareQueue));
        Thread consThread = new Thread(new Consumer(shareQueue));

        prodThread.start();
        consThread.start();

    }
}
