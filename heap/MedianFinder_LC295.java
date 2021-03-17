import java.util.*;

public class MedianFinder_LC295 {
    Queue<Integer> left = null;
    Queue<Integer> right = null;
    int sizeDiff = 0;

    /** initialize your data structure here. */
    public MedianFinder_LC295() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    /**
     * Adding a num entails maintaining some representation invariants A.
     * Left(max-heap) would contain ONE extra element, if num of elements seen so
     * far is odd. B. All elements in the left will be <= Elements in the right
     */
    public void addNum(int num) {
        if (left.isEmpty())
            left.add(num);
        else {
            // The current ele is HIGHER than the current highest element, we send it to the
            // LARGER half or MIN-HEAP
            if (num > left.peek())
                right.add(num);
            else
                left.add(num);
        }
        balanceHeap();
    }

    public double findMedian() {
        double median = 0.0;
        if (left.size() > right.size())
            median = left.peek().doubleValue();
        else if (right.size() > left.size())
            median = right.peek().doubleValue();
        else
            median = (right.peek() + left.peek()) * 0.5;

        return median;
    }

    private void balanceHeap() {
        if (left.size() > right.size() + 1) {
            right.add(left.remove());
        } else if (right.size() > left.size() + 1) {
            left.add(right.remove());
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
