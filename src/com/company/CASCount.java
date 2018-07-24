package com.company;

public class CASCount implements Runnable {
    private SimilatedCAS counter = new SimilatedCAS();

    public void run(){
        for(int i = 0;i<10000;i++){
            System.out.println(this.increment());
        }
    }
    public int increment(){
        int oldvalue = counter.getValue();
        int newvalue = oldvalue+1;

        while(!counter.compareAndSwap(oldvalue,newvalue)){
            oldvalue = counter.getValue();
            newvalue = oldvalue+1;
        }
        return newvalue;
    }
    class SimilatedCAS{
        private int value;
        public int getValue(){
            return value;
        }
        public synchronized boolean compareAndSwap(int expectedValue,int newValue){
            if(value==expectedValue){
                value = newValue;
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args){
        Runnable run = new CASCount();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
}
