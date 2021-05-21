import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MaxProfitInJobScheduling_LC1235 {
    // SDE problem
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int N = start.length;
        JobDetails[] jobs = new JobDetails[N];

        for (int i = 0; i < N; i++) {
            jobs[i] = new JobDetails(start[i], end[i], profit[i]);
        }
        Arrays.sort(jobs, (jobA, jobB) -> Integer.compare(jobA.end, jobB.end));

        NavigableMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (JobDetails job : jobs) {
            // We select the job ONLY if the result includes in a better profit
            int include = dp.floorEntry(job.start).getValue() + job.profit;
            if (include > dp.lastEntry().getValue()) {
                dp.put(job.end, include);
            }
        }
        return dp.lastEntry().getValue();
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
 * This is ONE of the best HARD problems in LEETCODE
 * In a sorting problem, we can almost use BINARY SEARCH OR NAVIGABLE MAP kind of DS
 * to efficiently resolve. 
 * This is SIMPLY a DP problem, because we have choice here. We ONLY pick a JOB if it results
 * in a better profit for us and we record the end time for that JOB
 * A MAP OF ENDTIME -> PROFIT.
 * So ,when we select the next JOB, sorted by their FINISH TIME, we know query the MAP
 * for the BEST profit of all jobs till the STAR TIME of the JOB
 */
