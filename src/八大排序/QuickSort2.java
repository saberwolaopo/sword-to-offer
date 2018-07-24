package 八大排序;

import java.util.Arrays;

public class QuickSort2 {
    public static void myquicksort(int[] nums, int low, int high){
        if(low<high){
            int middle = mygetmiddle(nums,low,high);
            myquicksort(nums,0,middle-1);
            myquicksort(nums,middle+1,high);
        }
    }

    private static int mygetmiddle(int[] nums, int low, int high) {
        int key = nums[low];
        while (low<high){
            while (low<high && nums[high]>key){
                high--;
            }
            nums[low] = nums[high];
            while (low<high && nums[low]<key){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = key;
        return high;
    }
    public static void main(String []args){
        int []nums = {1,6,3,2,9,4,5,7,8};
        myquicksort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
