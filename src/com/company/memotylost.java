package com.company;

import java.util.HashSet;

public class memotylost {
    public static void main(String []args){
        HashSet<Person> set = new HashSet<Person>();
        Person p1 = new Person();
        p1.setAge(12);
        p1.setName("蛙吹梅雨");
        Person p2 = new Person();
        p2.setAge(13);
        p2.setName("八百万八");
        Person p3 = new Person();
        p3.setAge(16);
        p3.setName("绿谷出久");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set.size());
        p3.setAge(22);
        set.remove(p3);
        set.add(p3);
        System.out.println(set.size());
    }

    private static class Person {
        String name;

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

        int age;

    }
}
