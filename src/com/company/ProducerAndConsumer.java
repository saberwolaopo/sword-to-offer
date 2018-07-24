package com.company;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {
    static class Producer implements Runnable{
        private final BlockingQueue shareQueue;

        public Producer(BlockingQueue shareQueue){
            this.shareQueue = shareQueue;
        }

        public void run(){
            for(int i=0;i<10;i++){
                try{
                    System.out.println("Produced: "+i);
                    shareQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Cusumer implements Runnable{
        private final BlockingQueue shareQueue;

        public Cusumer(BlockingQueue shareQueue){
            this.shareQueue = shareQueue;
        }

        public void run(){
            while(true){
                try{
                    int i = (int) shareQueue.take();
                    System.out.println("Consumed: "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        BlockingQueue shareQueue = new LinkedBlockingQueue();
        Thread prodThread = new Thread(new Producer(shareQueue));
        Thread consThread = new Thread(new Cusumer(shareQueue));

        prodThread.start();
        consThread.start();
    }
}
