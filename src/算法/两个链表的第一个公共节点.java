package 算法;

import java.util.List;

/*
题目描述
输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = GetLength(pHead1);
        int length2 = GetLength(pHead2);
        int diflength = length1-length2;
        ListNode longHead = pHead1;
        ListNode shortHead = pHead2;
        if(diflength<0){
            longHead = pHead2;
            shortHead = pHead1;
            diflength = length2-length1;
        }
        //让长的先走几步，直到当前位置与短的位置一样
        for(int i = 0;i<diflength;i++){
            longHead = longHead.next;
        }
        while(longHead!=null && shortHead!=null && longHead!=shortHead){
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        ListNode commonNode = longHead;
        return commonNode;
    }

    private int GetLength(ListNode node) {
        int length = 0;
        ListNode index = node;
        while(index!=null){
            index = index.next;
            length++;
        }
        return length;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}