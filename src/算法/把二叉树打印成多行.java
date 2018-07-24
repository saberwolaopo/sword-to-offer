package 算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> singleresult = new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        int start = 0;
        int end = 1;
        layer.add(pRoot);
        while (!layer.isEmpty()) {
            TreeNode temp = layer.remove();
            singleresult.add(temp.val);
            start++;
            if (temp.left != null) {
                layer.add(temp.left);
            }
            if (temp.right != null) {
                layer.add(temp.right);
            }
            if (start == end) {
                end = layer.size();
                start = 0;
                result.add(singleresult);
                singleresult = new ArrayList<>();
            }
        }
        return result;
    }
}