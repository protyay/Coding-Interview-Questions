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