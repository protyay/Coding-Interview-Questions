public class IntersectionOfLL_LC160 {
    // SDE problem
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null; // We won't have an intersection point

        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB)
            headA = forwardKNodes(headA, lenA - lenB);
        else
            headB = forwardKNodes(headB, lenB - lenA);

        // We have both the heads in place
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int len(ListNode head) {
        ListNode temp = head; // We don't want to modify the reference for the passed-in list
        int len = 0;
        while (temp != null) {
            ++len;
            temp = temp.next;
        }
        return len;
    }

    private ListNode forwardKNodes(ListNode head, int K) {
        if (head == null)
            return null;
        if (K == 0)
            return head;
        // We are going to have to modify the reference of the node passed-in.
        while (K-- > 0) {
            head = head.next;
        }
        return head;
    }
}
