package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
题目描述

Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
Initially, all next pointers are set toNULL.
Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class populating_next_right_pointers_in_each_node {
     public class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeLinkNode node = queue.poll();
                if(i == size-1){
                    node.next=null;
                }else{
                    node.next = queue.peek();
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
    }
}
