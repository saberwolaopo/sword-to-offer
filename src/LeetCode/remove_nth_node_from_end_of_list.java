package LeetCode;




/*
题目描述

Given a linked list, remove the n th node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class remove_nth_node_from_end_of_list {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getListLength(head);
        ListNode node = null;
        if(head == null || length <= 1){
            return node;
        }
        node = head;
        int flag = length-n;
        if(flag == 0){
            head = head.next;
            return head;
        }else{
            for(int i = 0;i<flag-1;i++){
                node = node.next;
            }
            node.next = node.next.next;
            return head;
        }
    }

    private static int getListLength(ListNode head) {
        int length = 1;
        while(head.next!=null){
            length++;
            head = head.next;
        }
        return length;
    }
    public static void main(String []args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        removeNthFromEnd(head,2);
        System.out.println(getListLength(head));
    }
}
