package LeetCode;

import java.util.ArrayList;

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class path_sum_ii {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> singleresult = new ArrayList<>();
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        singleresult.add(root.val);
        sum = sum - root.val;
        if(sum == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(singleresult));
        }
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        singleresult.remove(root.val);
        return result;
    }
}
