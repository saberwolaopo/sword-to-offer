package com.company.ConcurrentHashMap;

public class Thread1A extends Thread {
    private MyService1 service;

    public Thread1A(MyService1 service){
        super();
        this.service = service;
    }
    public void run(){
        for(int i = 0;i<50000;i++){
            service.map.put("ThreadA"+(i+1),"ThreadA"+i+1);
            System.out.println("ThreadA"+(i+1));
        }
    }
}
