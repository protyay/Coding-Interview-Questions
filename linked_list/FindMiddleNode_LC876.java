public class FindMiddleNode_LC876 {
    public ListNode middleNode(ListNode head) {
        // [1] -> 1
        // [1,2] -> 1
        // [1,2,3,4] -> Should we return 2 or 3 -> 3
        // []

        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}