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

class PallindromLL_LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the LL after the half partition
        ListNode prev = null;
        ListNode start = slow;

        while (start != null) {
            ListNode temp = start.next;
            start.next = prev;

            prev = start;
            start = temp;
        }

        // Iterate the head and the second half to check for pallindrome nature
        while (prev != null) {
            if (head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
