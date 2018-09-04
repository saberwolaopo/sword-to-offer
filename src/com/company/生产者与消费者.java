package com.company;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class 生产者与消费者 {
    public static class producer implements Runnable{
        private final BlockingQueue sharequeue;

        public producer(BlockingQueue sharequeue) {
            this.sharequeue = sharequeue;
        }

        @Override
        public void run() {
            for(int i = 0;i<10;i++){
                try {
                    System.out.println("product:"+i);
                    sharequeue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class consumer implements Runnable{
        private final BlockingQueue sharequeue;

        public consumer(BlockingQueue sharequeue) {
            this.sharequeue = sharequeue;
        }

        @Override
        public void run() {
            while (true){
                try{
                    int i = (int) sharequeue.take();
                    System.out.println("consume:"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String []args){
        BlockingQueue sharequeue = new LinkedBlockingQueue();
        Thread productThread = new Thread(new producer(sharequeue));
        Thread consumeThread = new Thread(new consumer(sharequeue));
        productThread.start();
        consumeThread.start();
    }
}
