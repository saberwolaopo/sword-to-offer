package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String []args){
        float f = 1.4f;
        double d = 1.4d;
        System.out.println(f==d);
        float f1 = 1.5f;
        double d1 = 1.5d;
        System.out.println(f1 == d1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(0);
        list.remove(1);
        HashMap<Integer,Student> map = new HashMap<>();
        Student s1 = new Student();
        s1.setName("123");
        s1.setAge(12);
        map.put(2,s1);
        map.get(2).equals(s1);
        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,2);
        String str=null;
        str.concat("abc");
        str.concat("123");
        System.out.println(str);


    }
    private static class Student{
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
