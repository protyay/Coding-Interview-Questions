import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray_BS {
    public int[] solve(int[][] lists) {
        List<Integer> mergedList = new ArrayList<>();
        Queue<ArrayEntry> pq = new PriorityQueue<>();
        int selectIdx = 0;
        // We select each of the first element from each of the K arrays
        for (int i = 0; i < lists.length; i++) {
            int[] list = lists[i];
            if (selectIdx < list.length) {
                pq.add(new ArrayEntry(list[selectIdx], i, selectIdx));
            }
        }
        // We've filled the pq with at-most K elements
        while (!pq.isEmpty()) {
            ArrayEntry currSmallest = pq.remove();
            mergedList.add(currSmallest.value);
            // Choose the next element from the current array
            selectIdx = currSmallest.indexInArr + 1;
            int[] currArray = lists[currSmallest.k];
            // If there's a valid index for selection, we select and it to the pq;
            if (selectIdx < currArray.length) {
                ArrayEntry nextEntry = new ArrayEntry(currArray[selectIdx], currSmallest.k, selectIdx);
                pq.add(nextEntry);
            }
        }
        int[] ans = mergedList.stream().mapToInt(i -> i).toArray();
        return ans;
    }

    class ArrayEntry implements Comparable<ArrayEntry> {
        int value;
        int k;
        int indexInArr;

        public ArrayEntry(int ele, int idx, int indexInArr) {
            this.value = ele;
            this.k = idx;
            this.indexInArr = indexInArr;
        }

        @Override
        public int compareTo(ArrayEntry lhs) {
            return this.value - lhs.value;
        }
    }

    /**
     * Leetcode 23 Solution
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // To achieve this in size K
        ListNode result = new ListNode();
        ListNode resultDup = result;
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        // Iterate through K-Linked List, insert the head node of each
        // into the Q - At most, the queue will contain K nodes, at any given time
        for (ListNode head : lists) {
            if (head == null)
                continue;
            minHeap.add(head);
        }
        while (!minHeap.isEmpty()) {
            ListNode currSmallest = minHeap.remove();
            result.next = currSmallest;
            result = result.next;
            if (currSmallest.next != null)
                minHeap.add(currSmallest.next);
        }
        return resultDup.next;
    }
}