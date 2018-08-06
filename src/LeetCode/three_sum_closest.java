package LeetCode;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class three_sum_closest {
    public int threeSumClosest(int[] num, int target) {
        int length = num.length;
        if(num == null && length < 3){
            return 0;
        }
        Arrays.sort(num);//把整个数组先从小到大排序
        int min = Integer.MAX_VALUE;
        int close = 0;

        for(int i = 0;i<length-2;i++){
            int l = i+1;
            int h = num.length-1;
            while(l<h){
                int gap = target-num[i]-num[l]-num[h];
                if(Math.abs(gap)<min){
                    min = Math.abs(gap);
                    close = num[i]+num[l]+num[h];
                }
                if(gap<0){//如果差值大了，说明末尾数字大了，就减1
                    h--;
                }else if(gap>0){//如果差值小了，说明中间数字小了，就加1
                    l++;
                }else{
                    close = num[i]+num[l]+num[h];
                    return close;
                }
            }
        }
        return close;
    }
}
