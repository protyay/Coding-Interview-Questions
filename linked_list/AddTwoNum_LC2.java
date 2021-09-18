public class AddTwoNum_LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;

            ListNode node = new ListNode(sum % 10);
            ans.next = node;
            ans = ans.next;

            sum /= 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (sum > 0) {
            ListNode carry = new ListNode(sum);
            ans.next = carry;
        }
        return temp.next;
    }
}
