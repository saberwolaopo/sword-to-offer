package com.company.ConcurrentHashMap;

public class Test1_1 {
    public static void main(String []args){
        MyService1 service = new MyService1();

        Thread1A a = new Thread1A(service);
        Thread1B b = new Thread1B(service);

        a.start();
        b.start();

    }
}
