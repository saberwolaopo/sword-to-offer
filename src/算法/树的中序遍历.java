package 算法;

import java.util.ArrayList;
import java.util.Stack;

public class 树的中序遍历 {
    private ArrayList<Integer> result = new ArrayList<>();
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
