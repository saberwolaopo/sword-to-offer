package LeetCode;

import java.util.ArrayList;

/*
题目描述

Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class pascals_triangle {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        for(int i = 0;i<numRows;i++){
            ArrayList<Integer> singleresult = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j == 0 || j == i ){
                    singleresult.add(1);
                }else {
                    singleresult.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(singleresult);
        }
        return result;
    }
}
