package 算法;
/*
题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        CloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectNodes(pHead);

    }

    private void ConnectSiblingNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node!=null){
            RandomListNode pClone = new RandomListNode(node.label);
            pClone.next = node.next;
            pClone.random = node.random;
            node.next = pClone;
            node = pClone.next;
        }
    }

    private void CloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node !=null){
            RandomListNode pClone = node.next;
            if(node.random!=null){
                pClone.random = node.random.next;
            }
            node = pClone.next;
        }
    }

    private RandomListNode ReconnectNodes(RandomListNode pHead){
        while (pHead!=null){
            pHead.next = pHead.next.next;
            if(pHead.next!=null){
                pHead.next.next = pHead.next.next.next;
            }
            pHead = pHead.next;
            pHead.next = pHead.next.next;
        }
        return pHead;
    }
}
