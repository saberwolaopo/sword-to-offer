package 算法;

import java.util.ArrayList;
import java.util.Stack;

/*
题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class 从尾到头打印链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            result.add(node.val);
        }
        return result;
    }
}
