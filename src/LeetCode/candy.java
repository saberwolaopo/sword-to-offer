package LeetCode;
/*
题目描述

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class candy {
    public int candy(int[] ratings) {
        int sum = 0;
        if(ratings == null || ratings.length<=1){
            return 1;
        }
        int length = ratings.length;
        int []candy = new int[length];
        for(int i = 0;i<length;i++){
            candy[i] = 1;
        }
        for(int i = 1;i<length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
        }
        for(int i = length-1;i>=1;i--){
            if(ratings[i]<ratings[i-1] && candy[i]>=candy[i-1]){
                candy[i-1] = candy[i]+1;
            }
        }
        for(int i = 0;i<length;i++){
            sum+=candy[i];
        }
        return sum;
    }
}
