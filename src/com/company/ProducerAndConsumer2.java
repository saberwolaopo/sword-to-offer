package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ProducerAndConsumer2 {
    public static void main(String []args){
        LinkedList linkedList = new LinkedList();
        ExecutorService service = Executors.newFixedThreadPool(15);
        for(int i = 0 ;i<5;i++){
            service.submit(new Producer(linkedList,8));
        }
        for(int i = 0;i<10;i++){
            service.submit(new Consumer(linkedList));
        }
    }
    static class Producer implements Runnable{
        private List<Integer> list;
        private int maxlength;

        public Producer(List list,int maxlength){
            this.list = list;
            this.maxlength = maxlength;
        }
        @Override
        public void run() {
            while(true){
                synchronized (list){
                    try{
                        while(list.size()==maxlength){
                            System.out.println("生产者"+Thread.currentThread().getName()+"  list已经达到最大容量，进行wait...");
                            list.wait();
                            System.out.println("生产者"+Thread.currentThread().getName()+"  退出wait");
                        }
                        Random random = new Random();
                        int i = random.nextInt();
                        System.out.println("生产者"+Thread.currentThread().getName()+"生产数据"+i);
                        list.add(i);
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class Consumer implements Runnable{
        private List<Integer> list;
        public Consumer(List list){
            this.list = list;
        }
        @Override
        public void run() {
            while(true){
                synchronized (list){
                    try{
                        while(list.isEmpty()){
                            System.out.println("消费者"+Thread.currentThread().getName()+"list为空，消费者wait...");
                            list.wait();
                            System.out.println("消费者"+Thread.currentThread().getName()+"list不为空，进行消费,退出wait");
                        }
                        Integer element = list.remove(0);
                        System.out.println("消费者"+Thread.currentThread().getName()+"消费数据："+element);
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
