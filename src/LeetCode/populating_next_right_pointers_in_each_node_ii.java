package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class populating_next_right_pointers_in_each_node_ii {
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
                if(i==size-1){
                    node.next = null;
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
