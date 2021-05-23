public class RotateList_LC61 {
    // SDE problem
    // REPEAT
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null)
            return head;
        ListNode headRef = head;
        // k can be greater than the list len

        int len = len(head);

        k = len - (k % len);
        if (len == k)
            return head;

        int idx = 1;
        ListNode last = last(head);
        while (idx++ < k) {
            head = head.next;
        }
        ListNode updatedHead = head.next;
        head.next = null;
        last.next = headRef;

        return updatedHead;
    }

    private int len(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            ++len;
        }
        return len;
    }

    private ListNode last(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
}
