package LeetCode;

import java.util.Arrays;

/*
题目描述

Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return[-1, -1].
For example,
Given[5, 7, 7, 8, 8, 10]and target value 8,
return[3, 4].

 */
public class search_for_a_range {
    public static int[] searchRange(int[] A, int target) {
        int []result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int length = A.length;
        if(A == null || length<1){
            return result;
        }
        int middle = 0;
        int start = 0;
        int end = length-1;
        while(start<=end){
            middle = (start+end)/2;
            if(target<A[middle]){
                end = middle-1;
            }else if(target>A[middle]){
                start = middle+1;
            }else{
                if(target == A[middle]){
                    int low = middle;
                    int high = middle;
                    while(low>=start && A[low] == target){
                        result[0] = low;
                        low--;
                    }
                    while(high<=end && A[high] == target){
                        result[1] = high;
                        high++;
                    }
                }
                return result;
            }
        }
        return result;
    }

    public static void main(String []args){
        int []A = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(A,5)));
    }
}