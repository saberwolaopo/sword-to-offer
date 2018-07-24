package 算法;

import java.util.Stack;

/*
题目描述
输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表的倒数第K个节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k<=0){
            return null;
        }
        int flag = 0;
        ListNode node = null;
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
            flag++;
        }
        if(flag<k){
            return null;
        }
        for(int i = 0;i<k;i++){
            node = stack.pop();
        }
        return node;
    }
}
