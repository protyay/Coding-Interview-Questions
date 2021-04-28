public class AddLinkedList_BS243 {

    public LLNode solve(LLNode l0, LLNode l1) {
        // Carry will move to the right node
        LLNode sumHead = new LLNode();
        LLNode dummySumHead = sumHead;

        int carryOut = 0;
        while (l0 != null && l1 != null) {
            int sum = l0.val + l1.val + carryOut;
            LLNode kNode = new LLNode();

            kNode.val = sum % 10;
            carryOut = sum / 10;

            dummySumHead.next = kNode;
            dummySumHead = dummySumHead.next;

            l0 = l0.next;
            l1 = l1.next;
        }
        // Traverse rest of the digits
        LLNode remaining = l0 == null ? l1 : l0;
        while (remaining != null) {
            int sum = carryOut + 0 + remaining.val;
            LLNode kNode = new LLNode();
            kNode.val = sum % 10;
            carryOut = sum / 10;
            dummySumHead.next = kNode;
            dummySumHead = dummySumHead.next;

            remaining = remaining.next;
        }
        // If two equal length list, but there's a valid NON-ZERO carryOut
        if (carryOut > 0) {
            LLNode carryNode = new LLNode();
            carryNode.val = carryOut;
            dummySumHead.next = carryNode;
        }
        return sumHead.next;
    }
}

class LLNode {
    int val;
    LLNode next;
}
/**
 * The common framework for string or LinkedList addition is to do
 * A. Traverse until both of the list(or string) are exhausted
 * B. Use the sum as the carry option
 */
class AddNumbers_LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode head = ans;

        int sum = 0;// Sum variable can be reused as carry
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode next = new ListNode(sum % 10);
            head.next = next;
            head = head.next;

            sum = sum / 10;
        }
        while (sum > 0) {
            ListNode lastNode = new ListNode(sum);
            head.next = lastNode;
            sum = sum / 10;
        }
        return ans.next;
    }
}