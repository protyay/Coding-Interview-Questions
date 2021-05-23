public class ReverseLL2_LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right || head.next == null)
            return head;

        ListNode reverseHead = new ListNode();
        reverseHead.next = head;

        ListNode dummyHead = reverseHead;
        int start = 1;
        while (start++ < left) {
            reverseHead = reverseHead.next;
        }
        ListNode pre = reverseHead;
        ListNode curr = pre.next;
        ListNode second = curr.next;

        while (left++ < right) {

            ListNode temp = second.next;
            second.next = pre.next;
            pre.next = second;
            curr.next = temp;
            second = curr.next;

        }
        return dummyHead.next;
    }
}

/**
 * https://www.youtube.com/watch?v=wk8-_M-2fzI Keep PRE and CURR constant in
 * each iteration. Update SECOND and NEXT pointers for BOTH PRE AND CURR
 * 
 */
