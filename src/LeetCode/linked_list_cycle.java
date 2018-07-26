package LeetCode;

import java.util.HashSet;

/*
题目描述

Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
 */
public class linked_list_cycle {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        boolean result = false;
        HashSet<ListNode> set = new HashSet<>();
        while(head.next!=null){
            if(!set.add(head)){
                result = true;
                break;
            }else{
                result = false;
            }
            head = head.next;
        }
        return result;
    }
}
