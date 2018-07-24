package com.company;
class Super{
    public static int m = 11;
    static {
        System.out.println("执行父类静态代码块");
    }
}
class Child extends Super{
    public static int n = 33;
    static {
        System.out.println("执行子类静态代码块");
    }
}
public class StaticTest {
    public static void main(String []args){
        System.out.println(Child.n);
    }
}
