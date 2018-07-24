package com.company;



import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.lang.Throwable;
import java.lang.Exception;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        printer.printmsg();

        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();


        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();
        inner2.display();
        TimeUnit.DAYS.sleep(1);
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("12");
        queue.put("23");
        queue.take();
        ArrayBlockingQueue queue1 = new ArrayBlockingQueue(10);
        queue1.put("1");
        queue1.offer("2");
        PrintWriter out = new PrintWriter(
                new java.io.OutputStreamWriter(System.out), true);
        out.println("Hello");
        ThreadLocal local = new ThreadLocal();
        local.set("1223");

    }

}
class OuterClass {
    private static String msg = "saber";

    public static class NestedStaticClass {
        public void printmsg() {
            System.out.println("静态内部类：" + msg);
        }
    }

    public class InnerClass {
        public void display() {
            System.out.println("非静态内部类:" + msg);
        }
    }
}
