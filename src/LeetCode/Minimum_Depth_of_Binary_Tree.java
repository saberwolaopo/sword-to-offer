package LeetCode;
/*
题目描述
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Minimum_Depth_of_Binary_Tree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left==null){
            return 1+run(root.right);
        }else if(root.right==null){
            return 1+run(root.left);
        }else{
            return Math.min(1+run(root.left),1+run(root.right));
        }
    }
}
