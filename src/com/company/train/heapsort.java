package com.company.train;

import java.util.Arrays;

public class heapsort {
    public static void adjustHeap(int[] a, int parent, int length){
        int left = 2*parent+1;
        int right = 2*parent+2;
        int largest = parent;
        while(true){
            if(left<length && a[left]>a[largest]){
                largest = left;
            }
            if(right<length && a[right]>a[largest]){
                largest = right;
            }
            if(parent!=largest){
                int temp = a[parent];
                a[parent] = a[largest];
                a[largest] = temp;
            }else{
                break;
            }
            parent = largest;
            left = 2*parent+1;
            right = 2*parent+2;
        }
    }
    public static void heap(int[] a){
        int length = a.length;
        for(int i = length/2;i>=0;i--){
            adjustHeap(a,i,length);
        }
        while(length>1){
            int temp = a[0];
            a[0] = a[length-1];
            a[length-1] = temp;
            length--;
            adjustHeap(a,0,length);
        }
    }
    public static void main(String []args){
        int []a = {1,6,7,23,66,11,44,73,576};
        heap(a);
        System.out.println(Arrays.toString(a));
    }
}
