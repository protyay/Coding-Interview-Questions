import java.util.Arrays;

public class MinDifficultyInJobSchedule_LC1335 {
    public int minDifficulty(int[] jobs, int d) {
        if (d > jobs.length)
            return -1;
        int[][] dp = new int[d + 1][jobs.length];
        for (int[] day : dp)
            Arrays.fill(day, -1);
        return dfsMax(d, jobs, 0, dp);
    }

    private int dfsMax(int d, int[] jobs, int idx, int[][] dp) {
        if (d == 1)
            return max(jobs, idx);
        if (dp[d][idx] > -1)
            return dp[d][idx];
        int currMax = 0;
        int min = Integer.MAX_VALUE;
        // i indicates the partition of the jobs array to form two segments
        // We choose all possible segments to make the cut
        for (int i = idx; i < jobs.length - d + 1; i++) {
            currMax = Math.max(currMax, jobs[i]);

            int maxOfRemainJobs = dfsMax(d - 1, jobs, i + 1, dp);
            if (maxOfRemainJobs == Integer.MAX_VALUE)
                continue;
            min = Math.min(min, currMax + maxOfRemainJobs);
        }
        return dp[d][idx] = min;
    }

    private int max(int[] jobs, int start) {
        int max = 0;
        for (int i = start; i < jobs.length; i++) {
            max = Math.max(jobs[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        MinDifficultyInJobSchedule_LC1335 lc1335 = new MinDifficultyInJobSchedule_LC1335();
        // int[] jobs = { 6, 5, 4, 3 };
        int[] jobs = { 6, 5, 4, 3, 2, 1 };
        // int[] jobs = { 7,1,7,1,7,1 };
        // int[] jobs = { 11,111,22,222,33,333,44,444 };
        // int[] jobs = { 186, 398, 479, 206, 885, 423, 805, 112, 925, 656, 16, 932,
        // 740, 292, 671, 360 };
        int d = 2;
        int minDifficulty = lc1335.minDifficulty(jobs, d);
        System.out.println("Min diff =" + minDifficulty);
    }

}
