package com.company;

public class 端口{
    public static void main(String[] args){
        int i=1;
        int count=0;
        while(i<65535){
            i*=2;
            count++;
        }
        System.out.println(i);
        System.out.println(count);
    }
}

