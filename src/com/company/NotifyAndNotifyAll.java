package com.company;

public class NotifyAndNotifyAll {
    private static final Object obj = new Object();
    static class R implements Runnable {
        int i;

        R(int i) {
            this.i = i;
        }

        public void run() {
            try {
                synchronized(obj) {
                    System.out.println("线程->  " + i + " 等待中");
                    obj.wait();
                    System.out.println("线程->  " + i + " 在运行了");
                    Thread.sleep(1000);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] rs = new Thread[10];
        for(int i = 0;i < 10;i++) {
            rs[i] = new Thread(new R(i));
        }
        for(Thread r : rs) {
            r.start();
        }

        Thread.sleep(5000);
        synchronized(obj) {
//            obj.notify();
            obj.notifyAll();
        }
    }
}
