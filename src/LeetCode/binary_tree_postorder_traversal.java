package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/*
题目描述

Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3

return[3,2,1].
Note: Recursive solution is trivial, could you do it iteratively?

 */
public class binary_tree_postorder_traversal {
    private ArrayList<Integer> result = new ArrayList<>();
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归方法后序遍历
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
    //非递归方法后序遍历
    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //每次放入首位，这是后续的关键!!!
            result.add(0,node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return result;
    }
}
