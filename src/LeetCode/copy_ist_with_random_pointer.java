package LeetCode;

public class copy_ist_with_random_pointer {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        CloneNodes(head);
        ConnectSiblingNodes(head);
        return ReconnectNodes(head);
    }
    private RandomListNode ReconnectNodes(RandomListNode head){
        while (head!=null){
            head.next = head.next.next;
            if(head.next!=null){
                head.next.next = head.next.next.next;
            }
            head = head.next;
            head.next = head.next.next;
        }
        return head;
    }

    private void CloneNodes(RandomListNode head) {
        RandomListNode node = head;
        while (node!=null){
            RandomListNode clone = new RandomListNode(node.label);
            clone.next = node.next;
            clone.random = node.random;
            node.next = clone;
            node = clone.next;
        }
    }

    private void ConnectSiblingNodes(RandomListNode head) {
        RandomListNode node = head;
        while(node!=null){
            RandomListNode clone = node.next;
            if(node.random!=null){
                clone.random = node.random.next;
            }
            node = clone.next;
        }
    }
}
