public class KthMissingPosNum_LC1539 {
    // SDE // Repeat
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0])
            return k;
        k -= arr[0] - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int miss = arr[i + 1] - arr[i] - 1;
            if (k <= miss)
                return arr[i] + k;
            k -= miss;
        }
        return arr[arr.length - 1] + k;
    }
}
/**
 * THis is NOT the most optimal solution
 */
