package LeetCode;
/*
题目描述

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
 */
public class search_in_rotated_sorted_array {
    public static int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        int length = A.length;
        int low = 0;
        int high = length-1;
        while(low<=high){
            if(A[low] == target){
                return low;
            }
            if(A[high] == target){
                return high;
            }
            if(target>A[low]){
                low++;
            }else{
                high--;
            }
        }
        return -1;
    }
    public static void main(String []args){
        int []A = {1};
        int target = 1;
        System.out.println(search(A,target));
    }
}
