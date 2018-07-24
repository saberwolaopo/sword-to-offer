package com.company;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String []args){
        ExecutorService exec = Executors.newFixedThreadPool(2);

        exec.execute(() -> {
            try {
                //男生对女生说的话
                String togirl = exchanger.exchange("我其实暗恋你很久了......");
                System.out.println("女孩儿说：" + togirl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        exec.execute(() -> {
            try {
                System.out.println("女生慢慢的从教室你里出来......");
                TimeUnit.SECONDS.sleep(3);
                //男生对女生说的话
                String toboy = exchanger.exchange("我也很喜欢你......");
                System.out.println("男孩儿说：" + toboy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
