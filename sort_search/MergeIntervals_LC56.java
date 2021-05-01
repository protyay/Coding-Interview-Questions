import java.util.Arrays;
import java.util.LinkedList;
/**
 * SDE problem
 */
public class MergeIntervals_LC56 {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals in asc order based on the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty() || list.getLast()[1] < intervals[i][0])
                list.add(intervals[i]);
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
/**
 * Sweet problem.
 * The underlying idea is to leverage sort and check overlap by checking if there's an overlap between where the last range ends
 * and where the current range starts.
 * Also, take care of the toArray method in how it's used in 2D array scenarios
 */