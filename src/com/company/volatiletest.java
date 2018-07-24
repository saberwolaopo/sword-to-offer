package com.company;


public class volatiletest {
    public static int i = 0;
    public static class volatileThread extends Thread{
        @Override
        public void run(){
            i+=1;
        }
    }
    public static void main(String []argv){
        volatileThread thread1 = new volatileThread();
        volatileThread thread2 = new volatileThread();
        thread1.start();
        thread2.start();
        System.out.println(i);
    }
}
