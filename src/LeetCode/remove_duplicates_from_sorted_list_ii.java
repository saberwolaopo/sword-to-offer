package LeetCode;
/*
题目描述

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.
 */
public class remove_duplicates_from_sorted_list_ii {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val == head.next.val){
            ListNode node = head.next;
            while (node!=null && node.val == head.val){
                node = node.next;
            }
            return deleteDuplicates(node);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
