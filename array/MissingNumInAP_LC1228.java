public class MissingNumInAP_LC1228 {
    public int missingNumber(int[] arr) {
        int N = arr.length;
        int diff = (arr[N - 1] - arr[0]) / N;
        int start = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == start + diff)
                start = arr[i];
            else
                break;
        }
        return start + diff;
    }
}
