public class DetectCycleinLL_LC141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
/**
 * Explain the O(N) space approach to the interviewer
 * TC - (N+K) Because inside the loop the fast pointer will cover extra steps before they both meet
 * So total steps = N+K
 */
