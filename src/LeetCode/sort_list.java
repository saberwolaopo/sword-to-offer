package LeetCode;
/*
题目描述

Sort a linked list in O(n log n) time using constant space complexity.


 */
public class sort_list {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeSort(sortList(head),sortList(midNext));
    }

    private ListNode mergeSort(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode node = null;
        if(l1.val<l2.val){
            node = l1;
            node.next = mergeSort(l1.next,l2);
        }else {
            node = l2;
            node.next = mergeSort(l1,l2.next);
        }
        return node;
    }

    private ListNode getMid(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick.next!=null && quick.next.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
