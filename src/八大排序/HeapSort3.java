package 八大排序;

import java.util.Arrays;

public class HeapSort3 {
    public static void adjustHeap3(int []nums,int parent,int length){
        int left = 2*parent+1;
        int right = 2*parent+2;
        int largest = parent;
        //建立大顶堆
        while(true){
            if(left<length && nums[left]>nums[largest]){
                 largest = left;
            }
            if(right<length && nums[right]>nums[largest]){
                 largest = right;
            }
            if(parent!=largest){
                int temp = nums[parent];
                nums[parent] = nums[largest];
                nums[largest] = temp;
            }else{
                break;
            }
            parent = largest;
            left = 2*parent+1;
            right = 2*parent+2;
        }
    }
    public static void heapsort3(int[] nums){
        int length = nums.length;
        for(int i = length/2;i>=0;i--){
            adjustHeap3(nums,i,length);
        }
        while(length>1){
            int temp = nums[length-1];
            nums[length-1] = nums[0];
            nums[0] = temp;
            length--;
            adjustHeap3(nums,0,length);
        }
    }
    public static void main(String[] args) {
        int[] array = { 1,6,3,2,9,4,5,7,8 };
        HeapSort3.heapsort3(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
