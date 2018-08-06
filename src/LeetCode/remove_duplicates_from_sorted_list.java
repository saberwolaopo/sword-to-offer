package LeetCode;
/*
题目描述

Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given1->1->2, return1->2.
Given1->1->2->3->3, return1->2->3.
 */
public class remove_duplicates_from_sorted_list {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null){
            while(node.next != null && node.val == node.next.val){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return node;
    }
}
