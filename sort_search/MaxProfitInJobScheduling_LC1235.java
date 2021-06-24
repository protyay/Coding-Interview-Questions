import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxProfitInJobScheduling_LC1235 {
    // SDE problem
    Map<Integer, Integer> dp = new HashMap<>();

    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int N = start.length;
        JobDetails[] jobs = new JobDetails[N];

        for (int i = 0; i < N; i++) {
            jobs[i] = new JobDetails(start[i], end[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j1 -> j1.start));
        return dfs(jobs, 0);
    }

    private int dfs(JobDetails[] jobs, int start) {

        if (start == jobs.length || start == -1)
            return 0;
            
        if (dp.containsKey(start))
            return dp.get(start);

        int next = search(jobs, jobs[start].end, start + 1);
        int profitWithCurr = jobs[start].profit + dfs(jobs, next);
        int profitWithout = dfs(jobs, start + 1);

        dp.put(start, Math.max(profitWithCurr, profitWithout));
        return Math.max(profitWithCurr, profitWithout);
    }

    private int search(JobDetails[] jobs, int target, int from) {
        // Search the Jobs array where the start index is greater than the end time.
        int lo = from, hi = jobs.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid].start >= target) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // [1,4,12],[2,6,23],[3,7,34],[4,8,45]
        int[] start = { 1, 2, 3, 4 }, end = { 4, 6, 7, 8 }, profit = { 12, 23, 34, 45 };
        MaxProfitInJobScheduling_LC1235 lc1235 = new MaxProfitInJobScheduling_LC1235();
        int maxProfit = lc1235.jobScheduling(start, end, profit);
        System.out.println("profit =" + maxProfit);
    }
}

class JobDetails {
    int profit;
    int start;
    int end;

    JobDetails(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
/**
 * This is ONE of the best HARD problems in LEETCODE In a sorting problem, we
 * can almost use BINARY SEARCH OR NAVIGABLE MAP kind of DS to efficiently
 * resolve. This is SIMPLY a DP problem, because we have choice here. We ONLY
 * pick a JOB if it results in a better profit for us and we record the end time
 * for that JOB A MAP OF ENDTIME -> PROFIT. So ,when we select the next JOB,
 * sorted by their FINISH TIME, we know query the MAP for the BEST profit of all
 * jobs till the STAR TIME of the JOB
 */
