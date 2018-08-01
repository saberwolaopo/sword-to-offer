package LeetCode;
/*
题目描述

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Above is a 3 x 7 grid. How many possible unique paths are there?
Note: m and n will be at most 100.

 */
public class unique_paths {
    public static int uniquePaths(int m, int n) {
        if(m < 1 || n < 1){
            return 0;
        }
        if(m<2 || n<2){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    public static void main(String []args){
        int m = 15;
        int n = 15;
        System.out.println(uniquePaths(m,n));
        System.out.println(uniquePaths2(m,n));
    }
    public static int uniquePaths2(int m, int n) {
if( m==0 || n==0) return 0;

int[][]res = new int[m][n];
//res[0][0] = obstacleGrid[0][0];
for(int i = 0;i<n;i++){
res[0][i] = 1 ;
}
for(int i = 0;i<m;i++){
res[i][0] = 1 ;
}
for(int i = 1;i<m;i++){
for(int j=1;j<n;j++){
res[i][j] = res[i-1][j]+res[i][j-1];
}
}
return res[m-1][n-1];
    }
}
