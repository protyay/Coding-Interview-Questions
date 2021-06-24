import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SplitArrayIntoKSubArrays_GFG {
    static long minimumCostDivision(int N, int K, int[] A) {
        // Write your code here
        if (A.length == 1)
            return 1L;

        Arrays.sort(A);
        long maxSum = 0;
        for (int i = 0; i < N; i++) {
            maxSum += A[i] * (i + 1);
        }
        // We'll use binary search from 1 to MaxSum
        // Our min sum would be to include the minimum element in a single length
        // subarray
        long minSum = Integer.MAX_VALUE;
        for (int i : A) {
            minSum = Math.min(minSum, i);
        }

        long ans = 0;
        long lo = minSum, hi = maxSum;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isRightCut(mid, N, K, A)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) ans;
    }

    private static boolean isRightCut(long mid, int N, int K, int[] A) {
        int subarrCount = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > mid)
                return false;
            sum += A[i] * (i + 1);

            if (sum > mid) {
                subarrCount++;
                sum = A[i];
            }
        }
        // ++subarrCount;
        if (++subarrCount <= K)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int N = 4, K = 4;
        int[] A = { 1, 2, 3, 4 };
        long minimumCostDivision = minimumCostDivision(N, K, A);
        System.out.println(minimumCostDivision);
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            System.out.print(r.nextInt(10_000_00) + " ");
        }
    }
}
