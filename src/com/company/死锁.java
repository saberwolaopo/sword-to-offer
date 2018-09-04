package com.company;

public class 死锁 {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static class lock1 implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("lock1 is running...");
                while (true){
                    synchronized (obj1){
                        System.out.println("lock1 is locking obj1...");
                        Thread.sleep(500);
                        synchronized (obj2){
                            System.out.println("lock1 is locking obj2...");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class lock2 implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("lock2 is running...");
                while (true){
                    synchronized (obj2){
                        System.out.println("lock2 is locking obj2...");
                        Thread.sleep(500);
                        synchronized (obj1){
                            System.out.println("lock2 is locking obj1...");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args){
        Thread a = new Thread(new lock1());
        Thread b = new Thread(new lock2());
        a.start();
        b.start();
    }
}
