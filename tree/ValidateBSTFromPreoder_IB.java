import java.util.ArrayList;

public class ValidateBSTFromPreoder_IB {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        if (N <= 2)
            return 1;
        int root = A.get(0);
        int idx = -1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > root) {
                idx = i;
                break;
            }
        }
        // idx value with -1 indicates that there's NO right sub-tree
        if (idx == -1) {
            idx = N;
        }
        ArrayList<Integer> ltree = new ArrayList<>(A.subList(1, idx));
        ArrayList<Integer> rtree = new ArrayList<>(A.subList(idx, N));

        for (int i = 0; i < ltree.size(); i++) {
            if (ltree.get(i) > root)
                return 0;
        }
        for (int i = 0; i < rtree.size(); i++) {
            if (rtree.get(i) < root)
                return 0;
        }

        if (solve(ltree) == 1 && solve(rtree) == 1)
            return 1;
        return 0;
    }
}
