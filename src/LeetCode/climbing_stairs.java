package LeetCode;
/*
题目描述

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class climbing_stairs {
    public static int climbStairs(int n) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
    public static int climbStairs2(int n) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int y = 1;
        int x = 1;
        int start = 0;
        for(int i = 2;i<=n;i++){
            start = y+x;
            x = y;
            y = start;
        }
        return start;
    }
    public static void main(String []args){
        System.out.println(climbStairs(13));
        System.out.println(climbStairs2(13));
    }
}
