package com.company.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class test_1 {
    public static class Myservice{
        private CountDownLatch down = new CountDownLatch(1);

        public void testMethod(){
            try{
                System.out.println(Thread.currentThread().getName()+"准备");
                down.await();
                System.out.println(Thread.currentThread().getName()+"结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void downMethod(){
            System.out.println("开始");
            down.countDown();
        }
    }
    public static class MyThread extends Thread{
        private Myservice myservice;

        public MyThread(Myservice myservice){
            super();
            this.myservice = myservice;
        }
        @Override
        public void run(){
            myservice.testMethod();
        }
    }
    public static void main(String []argv) throws InterruptedException {
        Myservice myservice = new Myservice();
        MyThread []array = new MyThread[10];
        for(int i = 0;i<array.length;i++){
            array[i] = new MyThread(myservice);
            array[i].setName("线程"+(i+1));
            array[i].start();
        }
        Thread.sleep(200);
        myservice.downMethod();
    }
}
