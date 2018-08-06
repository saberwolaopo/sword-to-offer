package LeetCode;
/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array A =[2,3,1,1,4]
The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)

 */
public class jump_game_ii {
    public int jump(int[] A) {
        int length = A.length;
        if(A == null || length < 1){
            return 0;
        }
        int furthest_pre = 0;//从开始位置到开始位置能走到的最大距离
        int furthest_cur = 0;//当前区域能走到的最大位置
        int steps = 0;//步数
        for(int i = 0;i<length;i++){
            //如果位置大于了长度，就返回steps
            if(furthest_pre>=length){
                return steps;
            }
            //如果当前索引大于最大距离,即走过了开始位置能够到达的最大位置，那么就把上一步能达到的最大位置甩给furthest_pre
            if(i>furthest_pre){
                furthest_pre = furthest_cur;
                steps++;
            }
            //最大位置
            furthest_cur = Math.max(furthest_cur,A[i]+i);
        }
        return steps;
    }
}
