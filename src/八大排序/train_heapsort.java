package 八大排序;

import java.util.Arrays;

public class train_heapsort {
    public static void adjustHeap(int []a,int parent,int length){
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
    public static void heapsort(int []a){
        int length = a.length;
        for(int i = length/2;i>=0;i--){
            adjustHeap(a,i,length);
        }
        while(length>1){
            int temp = a[length-1];
            a[length-1] = a[0];
            a[0] = temp;
            length--;
            adjustHeap(a,0,length);
        }
    }
    public static void main(String []args){
        int []nums = {2,4,5,7,1,3,6,9,8};
        heapsort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
