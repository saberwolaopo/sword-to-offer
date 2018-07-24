package com.company;

//死锁的一个简单例子
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String []args){
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}
class Lock1 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock1 is running");
            while(true){
                synchronized (DeadLock.obj1) {
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(500);
                    synchronized (DeadLock.obj2) {
                        System.out.println("Lock1 lock obj2");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Lock2 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock2 is running");
            while(true){
                synchronized (DeadLock.obj2) {
                    System.out.println("Lock1 lock obj2");
                    Thread.sleep(500);
                    synchronized (DeadLock.obj1) {
                        System.out.println("Lock1 lock obj1");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
