import java.util.*;

public class MedianFinder_LC295 {
    /** initialize your data structure here. */
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder_LC295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        rebalance();
    }

    public double findMedian() {
        int currSize = minHeap.size() + maxHeap.size();
        if (currSize == 1)
            return maxHeap.peek() * 1.00;

        if (currSize % 2 == 1)
        return maxHeap.peek() * 1.0;
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    // The rebalance is very important.
    // This method restores two invariants at each insert operation
    // Divide the stream data into two equal(almost) halves
    // The highest element in the maxHeap should be <= the lowest element in the
    // minHeap
    // If either of the invariant is not hold, then rebalance

    private void rebalance() {
        while (maxHeap.size() - minHeap.size() > 1)
            minHeap.add(maxHeap.remove());

        while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.remove());
            maxHeap.add(minHeap.remove());
        }
    }

    public static void main(String[] args) {
        MedianFinder_LC295 lc295 = new MedianFinder_LC295();
        lc295.addNum(1);
        lc295.addNum(2);
        System.out.println(lc295.findMedian());
        lc295.addNum(3);
        System.out.println(lc295.findMedian());
    }

}
/**
 * Always try with example to understand the scenario
 * 
 */
