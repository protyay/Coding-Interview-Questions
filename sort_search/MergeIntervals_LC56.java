import java.util.Arrays;
import java.util.LinkedList;

/**
 * SDE problem
 */
public class MergeIntervals_LC56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        // We are going to sort the arrays by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty())
                merged.addLast(interval);
            else {
                int[] last = merged.getLast();
                if (last[1] >= interval[0]) {
                    merged.removeLast();
                    last[1] = Math.max(interval[1], last[1]);
                    merged.add(last);
                } else
                    merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
/**
 * Sweet problem. The underlying idea is to leverage sort and check overlap by
 * checking if there's an overlap between where the last range ends and where
 * the current range starts. Also, take care of the toArray method in how it's
 * used in 2D array scenarios
 */