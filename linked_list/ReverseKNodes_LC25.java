public class ReverseKNodes_LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode temp = head;
        // Calculate the linked list length
        int len = 0;

        while (temp != null) {
            ++len;
            temp = temp.next;
        }
        // For each pointer update cycle, we move next by one no
        while (len >= k) {
            ListNode curr = prev.next;
            ListNode second = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = second.next;
                second.next = prev.next;
                prev.next = second;
                second = curr.next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }
}
/**
 * We maintain three pointers, prev, curr, second In this reversal, we move K
 * -Groups at a time. 
 * We keep curr pointer fixed, and move second one node
 * ahead(Line 22)
 * On completion of a reversal of a group - we simply use prev =
 * curr(Line 26) to setup curr and second invariant for the next group.
 * 
 * 
 * Clsrification Questions - How to handle scenarios if K > Len AND scenario for handling elements
 * in a group less than K elements
 * 
 * Video reference - 
 * https://www.youtube.com/watch?v=Of0HPkk3JgI&t=376s
 */
