package LeetCode;
/*
题目描述

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path1->2->3which represents the number123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.
Return the sum = 12 + 13 =25.

 */
public class sum_root_to_leaf_numbers {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null){
            return sum;
        }
        return fun(root,sum);
    }

    private int fun(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        sum = sum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        return fun(root.left,sum)+fun(root.right,sum);
    }
}
