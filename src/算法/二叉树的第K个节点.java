package 算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
题目描述
给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class 二叉树的第K个节点 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode KthNode(TreeNode pRoot, int k)
        {

            HashMap<TreeNode,Integer> map = new HashMap<>();
            map = fun(pRoot,map);
            int size = map.size();
            if(k<1 || k>size){
                return null;
            }
            ArrayList<Integer> list  = new ArrayList<>();
            for(TreeNode node : map.keySet()){
                list.add(map.get(node));
            }
            int []array = new int[size];
            for(int i = 0;i<list.size();i++){
                array[i] = list.get(i);
            }
            Arrays.sort(array);
            int result = array[k-1];
            for(TreeNode node : map.keySet()){
                if(map.get(node).equals(result)){
                    return node;
                }
            }
            return null;
        }
    private static HashMap<TreeNode,Integer> fun(TreeNode pRoot,HashMap map) {
        if(pRoot!=null){
            map.put(pRoot,pRoot.val);
            fun(pRoot.left,map);
            fun(pRoot.right,map);
        }
        return map;
    }
    public static void main(String []args){
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode resultnode = KthNode(root,9);
        System.out.println(resultnode.val);
    }
}
