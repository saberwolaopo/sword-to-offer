package LeetCode;
/*
题目描述

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray[4,−1,2,1]has the largest sum =6.
click to show more practice.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class maximum_subarray {
    public int maxSubArray(int[] A) {
        int length = A.length;
        int sum = 0;
        int maxSum = A[0];
        for(int i = 0;i<length;i++){
            if(sum >= 0){
                sum += A[i];
            }else {
                sum = A[i];
            }
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    public int maxSubArray2(int[] A){
        int length = A.length;
        int sum = 0;
        int maxSum = 0;
        for(int i = 0;i<length;i++){
            sum = Math.max(sum,sum+A[i]);
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
