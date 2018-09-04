package LeetCode;



/*
题目描述

Sort a linked list using insertion sort.


 */
public class insertion_sort_list {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while(cur!=null){
            ListNode next = cur.next;
            pre = dumy;
            while(pre.next!=null && pre.next.val<cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dumy.next;
    }
}
