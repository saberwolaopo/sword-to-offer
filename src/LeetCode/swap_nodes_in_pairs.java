package LeetCode;

import java.util.Stack;

/*
题目描述

Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given1->2->3->4, you should return the list as2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */
public class swap_nodes_in_pairs {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode ptr1 = fake;
        ListNode ptr2 = head;

        while(ptr2!=null && ptr2.next!=null){
            ListNode nextstart = ptr2.next.next;//nextstart = 3
            ptr2.next.next = ptr2;  //2-->1
            ptr1.next = ptr2.next;  //fake-->2
            ptr2.next = nextstart;  //1-->3

            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return fake.next;
    }
}
