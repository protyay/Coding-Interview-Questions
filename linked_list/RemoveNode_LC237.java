public class RemoveNode_LC237 {
    public void deleteNode(ListNode node) {
        // The trick is to DELETE the next node by copying over it's value to the current node
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
