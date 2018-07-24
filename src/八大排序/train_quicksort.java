package 八大排序;

import java.util.Arrays;

public class train_quicksort {
    public static void quicksort(int []a,int low,int high){
        if(low<high){
            int middle = getmiddle(a,low,high);
            quicksort(a,low,middle-1);
            quicksort(a,middle+1,high);
        }
    }

    private static int getmiddle(int[] a, int low, int high) {
        int key = a[low];
        while(low<high){
            while(low<high && a[high]>key){
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low]<key){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
    public static void main(String []args){
        int []nums = {2,4,5,7,1,3,6,9,8};
        quicksort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
