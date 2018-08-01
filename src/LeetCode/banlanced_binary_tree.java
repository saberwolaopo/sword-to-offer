package LeetCode;
/*
题目描述

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class banlanced_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        int leftdepth = getdepth(root.left);
        int rightdepth = getdepth(root.right);
        int value = Math.abs(leftdepth-rightdepth);
        if(value>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getdepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getdepth(root.left)+1;
        int right = getdepth(root.right)+1;
        return Math.max(left,right);
    }
}

