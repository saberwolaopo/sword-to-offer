package com.company;

public class Singleton {
    //懒汉线程安全单例模式
    static class Singleton1{
        private static Singleton1 Instance = null;
        public Singleton1(){

        }
        public static synchronized Singleton1 getInstance(){
            if(Instance == null){
                Instance = new Singleton1();
            }
            return Instance;
        }
    }
    //饿汉式单例模式
    static class Singleton2{
        private static Singleton2 Instance = new Singleton2();
        public Singleton2(){

        }
        public static Singleton2 getInstance(){
            return Instance;
        }
    }
    //静态内部类(推荐)
    static class Singleton3{
        private static class InnerSingleton{
            private static final Singleton3 Instance = new Singleton3();
        }
        public Singleton3(){

        }
        public static Singleton3 getInstance(){
            return InnerSingleton.Instance;
        }
    }
}
