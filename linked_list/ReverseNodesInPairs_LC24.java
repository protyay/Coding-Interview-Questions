public class ReverseNodesInPairs_LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next.next;
            ListNode second = curr.next;

            // Reverse
            second.next = curr;
            curr.next = temp;
            prev.next = second;

            // Update
            prev = curr;
            curr = temp;
        }
        return dummy.next;
    }
}
/**
 * For each LL problems with pointer manipulation
 * try to follow the pre, curr and next framework
 * 
 * Pre is (usually) a dummy node
 * curr is the start node, next is (usually) the second node
 */
