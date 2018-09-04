package LeetCode;

import java.util.Arrays;

/*
题目描述

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class two_sum {
    public static int[] twoSum(int[] numbers, int target) {
        int []result = new int[2];
        int length = numbers.length;
        int pretarget = target;
        for(int i = 0;i<length;i++){
            pretarget = target-numbers[i];
            for(int j = i+1;j<length;j++){
                if(pretarget == numbers[j]){
                    result[0] = i+1;
                    result[1] = j+1;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String []args){
        int []number = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(number,target)));
    }
}
