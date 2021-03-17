public class ReverseLL2_LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right)
            return head;
        ListNode dummyHead = new ListNode(-1, head);
        int k = 1;
        ListNode pre = dummyHead;
        // Remember pre - curr - next drawing
        while (k++ < left) {
            pre = pre.next;
        }
        // Temp head points to previous of
        ListNode curr = pre.next;
        // be very cautious about how many times this while loop runs.
        while (left++ < right) {
            ListNode tempNext = curr.next;
            curr.next = tempNext.next;
            tempNext.next = pre.next;
            pre.next = tempNext;
        }
        return dummyHead.next;
    }
}
/**
 * https://www.youtube.com/watch?v=wk8-_M-2fzI
 */
