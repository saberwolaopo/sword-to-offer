package LeetCode;

import java.util.Stack;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

 */
public class validate_binary_search_tree {
    boolean flag = true;
    TreeNode node = null;
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() && cur!=null){
            if(cur == null){
                cur = stack.pop();
                if(pre!=null && pre.val >= cur.val){
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return true;
    }
    public boolean isValidBST2(TreeNode root){
        fun(root);
        return flag;
    }

    private void fun(TreeNode root) {
        if(root == null){
            return;
        }
        fun(root.left);
        if(node!=null && node.val>=root.val){
            flag = false;
        }
        node = root;
        fun(root.right);
    }
}
