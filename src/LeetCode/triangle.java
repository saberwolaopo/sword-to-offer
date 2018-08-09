package LeetCode;

import java.util.ArrayList;

/*
题目描述

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int sum = getminimumTotal(triangle,0,0);
        return sum;
    }

    private int getminimumTotal(ArrayList<ArrayList<Integer>> triangle, int l, int k) {
        int sum =  triangle.get(l).get(k);
        if(l<triangle.size()-1){
            sum = sum + Math.min(getminimumTotal(triangle,l+1,k),getminimumTotal(triangle,l+1,k+1));
        }
        return sum;
    }
}
