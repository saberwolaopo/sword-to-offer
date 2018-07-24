package com.company;

import java.util.Comparator;
import java.util.TreeMap;

public class test {
    private int a=10;
    int b=20;
    static int c=1;
    public static void main(String []args){
        TreeMap treeMap = new TreeMap(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age-o2.age;
            }
        });
        Student s1 = new Student(100);
        Student s2 = new Student(90);
        Student s3 = new Student(55);
        Student s4 = new Student(87);
        Student s5 = new Student(77);

        treeMap.put(s1,1);
        treeMap.put(s2,2);
        treeMap.put(s3,3);
        treeMap.put(s4,4);
        treeMap.put(s5,5);
        System.out.println(treeMap);
        s1.age=23;
        System.out.println(treeMap);
        test t = new test();
        int ii = t.a;
        int iii = test.c;
        System.out.println(5+~10);
        t.test1();


    }
    private static class Student{
        int age;
        public Student(int age){
            this.age = age;
        }
        @Override
        public String toString(){
            return "Student [age = "+age+"]";
        }
    }
    private synchronized void test1(){
        System.out.println("进入test1");
        test2();
    }
    private synchronized void test2(){
        System.out.println("进入test2");
    }

}
