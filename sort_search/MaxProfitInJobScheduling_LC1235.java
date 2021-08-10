import java.util.Arrays;

public class MaxProfitInJobScheduling_LC1235 {
    private Integer[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;
        Job[] jobs = new Job[N];
        this.dp = new Integer[N + 1];

        for (int i = 0; i < N; i++) {
            Job j = new Job(startTime[i], endTime[i], profit[i]);
            jobs[i] = j;
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        int[] startTimeSorted = new int[N];
        for (int i = 0; i < N; i++) {
            startTimeSorted[i] = jobs[i].start;
        }
        return findMaxProfit(jobs, startTimeSorted, 0);
    }

    private int findMaxProfit(Job[] jobs, int[] startTimes, int index) {
        if (index >= jobs.length)
            return 0;
        if (dp[index] != null)
            return dp[index];

        // Find the next non-conflicting job for scheduling
        int nextJobIndex = findNextJob(jobs[index].end, startTimes, index + 1);

        int select = jobs[index].profit + (nextJobIndex == -1 ? 0 : findMaxProfit(jobs, startTimes, nextJobIndex));
        int reject = findMaxProfit(jobs, startTimes, index + 1);

        return dp[index] = Math.max(select, reject);
    }

    private int findNextJob(int lowerBound, int[] startTimes, int index) {
        int lo = 0, hi = startTimes.length - 1;
        int scheduleTime = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (startTimes[mid] >= lowerBound) {
                scheduleTime = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return scheduleTime;
    }
}

class Job {

    int start;
    int end;
    int profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
