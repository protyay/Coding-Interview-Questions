public class PallindromeLL_BS42 {
    public boolean solve(LLNode node) {
        if (node == null)
            return true;
        if (node.next == null)
            return true;

        LLNode head = node;

        LLNode slow = node;
        LLNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half of the list
        LLNode prev = null;
        LLNode curr = slow.next;
        while (curr != null) {
            LLNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        LLNode middleHead = prev;
        System.out.println(slow.val);
        System.out.println(head.val);
        
        while (head != null && middleHead != null) {
            if (head.val != middleHead.val)
                return false;
            head = head.next;
            middleHead = middleHead.next;
        }
        return true;
    }
}
