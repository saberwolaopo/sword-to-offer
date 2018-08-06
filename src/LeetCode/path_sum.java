package LeetCode;


/*
题目描述

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */
public class path_sum {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null){
                return false;
            }
            if(root.left==null && root.right == null && sum-root.val==0){
                return true;
            }
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
