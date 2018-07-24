package com.company.ConcurrentHashMap;

public class Thread1B extends Thread{
    private MyService1 service;

    public Thread1B(MyService1 service){
        super();
        this.service = service;
    }
    public void run(){
        for(int i = 0;i<50000;i++){
            service.map.put("ThreadB"+(i+1),"ThreadB"+i+1);
            System.out.println("ThreadB"+(i+1));
        }
    }
}
