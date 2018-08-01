package LeetCode;


import java.util.HashMap;

/*
题目描述

Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class single_number_ii {
    public int singleNumber(int[] A) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            if(map.containsKey(A[i])){
                map.put(A[i],map.get(A[i])+1);
            }else{
                map.put(A[i],1);
            }
        }
        for(Integer integer: map.keySet()){
            if(map.get(integer).equals(1)){
                result = integer;
            }
        }
        return result;
    }
}
