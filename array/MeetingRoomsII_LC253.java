import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII_LC253 {
    // SDE problem
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        if (intervals.length == 1)
            return 1;

        Queue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] meeting = intervals[i];
            if (meeting[0] >= pq.peek())
                pq.remove();
            pq.add(meeting[1]);
        }
        return pq.size();
    }
}
