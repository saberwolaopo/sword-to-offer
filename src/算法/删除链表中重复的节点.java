package 算法;

import java.util.HashSet;
import java.util.Iterator;

/*
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next==null){
            return pHead;
        }
        if(pHead.val == pHead.next.val){
            ListNode node = pHead.next;
            while(node!=null && node.val == pHead.val){
                node = node.next;
            }
            return deleteDuplication(node);
        }else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
