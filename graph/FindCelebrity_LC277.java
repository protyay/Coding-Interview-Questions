import java.util.HashMap;
import java.util.Map;

public class FindCelebrity_LC277 {
    // Brute Force
    public int findCelebrity(int n) {
        int[] rel = new int[n];
        Map<Integer, Integer> knowsCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (this.knows(i, j)) {
                    rel[j]++;
                    knowsCount.put(i, knowsCount.getOrDefault(i, 0) + 1);
                }
            }
        }
        int celeb = -1;
        for (int i = 0; i < n; i++) {
            if (rel[i] == n - 1 && !knowsCount.containsKey(i)) {
                celeb = i;
                break;
            }
        }
        return celeb;
    }

    private boolean knows(int i, int j) {
        return false;
    }
}
