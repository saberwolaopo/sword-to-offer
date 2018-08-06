package LeetCode;
/*
题目描述

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example,
Given[0,1,0,2,1,0,1,3,2,1,2,1], return6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Thanks Marcos for contributing this image!

 */
public class trapping_rain_water {
    public int trap(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int length = A.length;
        int max = 0;
        int v = 0;
        int []container = new int[length];
        for(int i = 0;i<length;i++){
            container[i] = max;
            max = Math.max(max,A[i]);
        }
        max = 0;
        for(int i = length-1;i>=0;i--){
            container[i] = Math.min(max,container[i]);
            max = Math.max(max,A[i]);
            v += container[i] - A[i] > 0 ? container[i] - A[i] : 0;
        }
        return v;
    }
}
