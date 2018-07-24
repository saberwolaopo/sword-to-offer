package 算法;

import java.util.ArrayList;
import java.util.Stack;

/*
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        Stack<TreeNode> odd_number = new Stack<>();//存放奇数层节点
        odd_number.push(pRoot);
        Stack<TreeNode> even_number = new Stack<>();//存放偶数层节点
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(!odd_number.isEmpty() || !even_number.isEmpty()){
            //如果是奇数层
            if(layer%2!=0){
                ArrayList<Integer> odd_result = new ArrayList<>();
                while(!odd_number.isEmpty()){
                    TreeNode node = odd_number.pop();
                    if(node!=null){
                        odd_result.add(node.val);
                        even_number.push(node.left);
                        even_number.push(node.right);
                    }
                }
                if(!odd_result.isEmpty()){
                    result.add(odd_result);
                    layer++;
                }
                //如果是偶数层
            }else{
                ArrayList<Integer> even_result = new ArrayList<>();
                while(!even_number.isEmpty()){
                    TreeNode node = even_number.pop();
                    if(node!=null){
                        even_result.add(node.val);
                        odd_number.push(node.right);
                        odd_number.push(node.left);
                    }
                }
                if(!even_result.isEmpty()){
                    result.add(even_result);
                    layer++;
                }
            }
        }
        return result;
    }
}
