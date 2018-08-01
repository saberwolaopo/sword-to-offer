package LeetCode;

public class merge_two_sorted_lists {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l1 != null ){
            return l1;
        }
        ListNode node = null;
        if(l1.val<l2.val){
            node = l1;
            node.next=mergeTwoLists(l1.next,l2);

        }else{
            node = l2;
            node.next=mergeTwoLists(l1,l2.next);
        }
        return node;
    }
}