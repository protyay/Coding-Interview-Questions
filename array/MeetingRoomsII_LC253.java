import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII_LC253 {
    // SDE problem
    public int minMeetingRooms(int[][] intervals) {
        int room = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int[] interval : intervals) {
            // We allocate new room when the min end time of all meetings started
            // before the current meeting is greater than the current meeting
            // starting time

            if (minHeap.isEmpty() || interval[0] < minHeap.peek()) {
                ++room;
                minHeap.add(interval[1]);
            } else {
                minHeap.remove();
                minHeap.add(interval[1]);
            }
        }
        return room;
    }
}
