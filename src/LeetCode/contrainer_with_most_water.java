package LeetCode;
/*
题目描述

Given n non-negative integers a1 , a2 , ..., an , where each represents a point at coordinate (i, ai ).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai ) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
 */
public class contrainer_with_most_water {
    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }

        int left = 0;
        int right = height.length-1;
        int maxV = 0;
        while(left<right){
            int v = Math.min(height[left],height[right]) * (right-left);//算出此时此刻的容量
            maxV = Math.max(v,maxV);//算出容量最大值
            if(height[left]<height[right]){//如果左边高度小于右边高度，那么就试着抬高左边高度
                left++;
            }else {//否则抬高右边的高度
                right--;
            }
        }
        return maxV;
    }
}
