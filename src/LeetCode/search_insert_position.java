package LeetCode;
/*
题目描述

Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class search_insert_position {
    public int searchInsert(int[] A, int target) {
        int length = A.length;
        int left = 0;
        int right = length-1;
        if(A[left]>target){
            return 0;
        }
        if(A[right]<target){
            return length;
        }
        for(int i = 0;i<length;i++){
            if(A[i] == target){
                return i;
            }
            if(A[i]<target && A[i+1]>target){
                return i+1;
            }
        }
        return 0;
    }
    public int searchInsert2(int[] A, int target) {
        int length = A.length;
        int low = 0;
        int high = length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid]==target){
                return mid;
            }else if(A[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
