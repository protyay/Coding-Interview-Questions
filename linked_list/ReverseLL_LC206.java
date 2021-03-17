public class ReverseLL_LC206 {
    public ListNode reverseList(ListNode head) {
        // [1,2,3]
        // [1] -> 1
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }