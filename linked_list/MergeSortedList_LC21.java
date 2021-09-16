public class MergeSortedList_LC21 {
    // SDE problem
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();

        ListNode temp = ans;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            } else {
                if (l1 != null) {
                    temp.next = l1;
                    l1 = l1.next;
                    temp = temp.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                    temp = temp.next;
                }
            }
        }
        return ans.next;
    }
}
