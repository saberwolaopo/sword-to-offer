package com.company.train;

import java.util.Arrays;

public class quicksort {
    public static void quick(int[] a, int low, int high){
        if(low<high){
            int middle = getmiddle(a,low,high);
            quick(a,low,middle-1);
            quick(a,middle+1,high);
        }
    }
    private static int getmiddle(int[] a, int low, int high) {
        int key = a[low];
        while(low<high){
            while (low<high && a[high]>=key){
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low]<=key){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
    public static void main(String []args){
        int []a = {1,5,6,12,346,325,13,44};
        quick(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
