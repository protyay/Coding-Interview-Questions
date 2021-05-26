import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class BestOfFive_LC1086 {
    // SDE problem
    public int[][] highFive(int[][] items) {
        Comparator<int[]> idComp = (a, b) -> Integer.compare(a[0], b[0]);
        Comparator<int[]> marksComp = idComp.thenComparing((a, b) -> Integer.compare(b[1], a[1]));

        Arrays.sort(items, marksComp);
        
        int sum = 0;
        int prev = items[0][0];
        int seen = 0;
        LinkedList<int[]> merged = new LinkedList<>();

        for (int i = 0; i < items.length; i++) {
            int curr = items[i][0];

            if (curr == prev && i - seen + 1 <= 5) {
                sum += items[i][1];
            }
            if (i - seen + 1 == 5) {
                merged.add(new int[] { prev, sum / 5 });
            }
            if (curr != prev) {
                prev = curr;
                seen = i;
                sum = items[i][1];
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
