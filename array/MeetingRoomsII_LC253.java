import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII_LC253 {
    // SDE problem
    public int minMeetingRooms(int[][] intervals) {
        // Wes sort the array based on start time
        // We allocate a meeting room and keep the end time
        // in a min-heap. If the current meeting start time is less than the
        // prev.meeting end time,
        // then we allocate a new room. Add the current meeting end time on the
        // min-heap.
        // When we see the next meeting, we check if the start time of this meeting is
        // before the end time of the min-end time till now(Which is the top element of
        // the min heap)
        // if that's the case , then we allocate this room(don't increment the room
        // count)
        // and add the current meeting's end time into the min-heap for deciding next
        // meetings

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        int req = 0;
        for (int[] i : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(i[1]);
                ++req;
            } else if (i[0] < minHeap.peek()) {
                // All the rooms allocated can not be reused.
                ++req;
                minHeap.add(i[1]);
            } else if (i[0] >= minHeap.peek()) {
                minHeap.remove();
                minHeap.add(i[1]);
            }
        }
        return req;
    }
}
