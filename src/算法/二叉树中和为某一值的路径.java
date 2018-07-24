package 算法;

import java.util.ArrayList;



/*
题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> singleresult = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root == null ){
            return result;
        }
        singleresult.add(root.val);
        target = target-root.val;
        if(target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(singleresult));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        singleresult.remove((Integer)root.val);
        return result;
    }
}
