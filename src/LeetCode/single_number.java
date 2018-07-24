package LeetCode;

import java.util.HashSet;

/*
题目描述

Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
public class single_number {
    public int singleNumber(int[] A) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        int length = A.length;
        for(int i = 0;i<length;i++){
            if(!set.add(A[i])){
                set.remove(A[i]);
            }else {
                set.add(A[i]);
            }
        }
        for(Integer i : set){
            result = i;
        }
        return result;
    }
}
