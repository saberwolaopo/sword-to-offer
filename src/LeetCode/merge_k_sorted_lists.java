package LeetCode;

import java.util.ArrayList;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class merge_k_sorted_lists {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size()==0){
            return null;
        }
        return mergeKList(lists,0,lists.size()-1);
    }

    private ListNode mergeKList(ArrayList<ListNode> lists, int low, int high) {
        if(low>=high){
            return lists.get(low);
        }
        int mid = low+(high-low)/2;
        ListNode left = mergeKList(lists,low,mid);
        ListNode right = mergeKList(lists,mid+1,high);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if(left == null ){
            return right;
        }
        if(right == null ){
            return left;
        }
        ListNode node = null;
        if(left.val<right.val){
            node = left;
            node.next=merge(left.next,right);

        }else{
            node = right;
            node.next=merge(left,right.next);
        }
        return node;
    }
}
