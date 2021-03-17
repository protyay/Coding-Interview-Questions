public class Merge2SortedArrays_BS79 {
    // Very careful about unequal length lists
    public int[] solve(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0)
            return a.length == 0 ? b : a;
        int N = a.length + b.length;
        int[] res = new int[N];
        int endA = a.length - 1;
        int endB = b.length - 1;
        for (int i = N - 1; i >= 0 && endA >= 0 && endB >= 0; i--) {
            if (a[endA] > b[endB]) {
                res[i] = a[endA--];
            } else {
                res[i] = b[endB--];
            }
        }
        if (endA >= 0) {
            // Exhausted all elements
            for (int k = endA; k >= 0; k--) {
                res[k] = a[k];
            }
        } else {
            for (int k = endB; k >= 0; k--) {
                res[k] = b[k];
            }
        }

        return res;
    }
}
