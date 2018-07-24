package mysort;

import java.util.Arrays;

public class bubbleSort {
    public static void bubblesort(int a[]){
        int length = a.length;
        for(int i = 0;i<length-1;i++){
            for(int j = 0;j<length-1-i;j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String []args){
        int []a = {5,2,53,612,22,12,56,222,98};
        bubblesort(a);
        System.out.println(Arrays.toString(a));
    }
}
