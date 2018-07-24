package 算法;

import java.util.HashSet;

/*
题目描述
一个链表中包含环，请找出该链表的环的入口结点。
 */
/*
利用hashset不允许重复的特点，加入相同的node肯定会返回false来找到入口节点
 */
public class 链表中环的入口节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashSet<ListNode> set = new HashSet<>();
        while(pHead.next!=null){
            if(!set.add(pHead)){
                return pHead;
            }
            pHead=pHead.next;
        }
        return null;
    }
}
