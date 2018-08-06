package LeetCode;
/*
题目描述

Given a number represented as an array of digits, plus one to the number.
 */
public class plus_one {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i] = 0;
            }else {
                digits[i] = digits[i]+1;
                break;
            }
        }
        if(digits[0] == 0){
            int []result = new int[digits.length+1];
            result[0] = 1;
            for(int i = 1;i<result.length;i++){
                result[i] = 0;
            }
            return result;
        }
        return digits;
    }
}
