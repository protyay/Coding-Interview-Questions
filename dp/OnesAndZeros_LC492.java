import java.util.HashMap;
import java.util.Map;

public class OnesAndZeros_LC492 {
    private Integer[][][] cache = new Integer[601][101][101];

    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Entry> binCount = new HashMap<>();
        for (String str : strs) {
            int one = 0, zero = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    ++zero;
                else
                    ++one;
            }
            Entry a = new Entry(one, zero);
            binCount.put(str, a);
        }
        return knapsack(strs, m, n, 0, binCount);
    }

    private int knapsack(String[] strs, int zeroes, int ones, int index, Map<String, Entry> binCount) {
        if (index == strs.length || (zeroes + ones == 0)) {
            return 0;
        }
        if (cache[index][zeroes][ones] != null)
            return cache[index][zeroes][ones];

        // Check if this element CAN be included
        Entry strEntry = binCount.get(strs[index]);
        if (strEntry.oneCount <= ones && strEntry.zeroCount <= zeroes) {
            // Include in knapsack
            int addCount = 1
                    + knapsack(strs, zeroes - strEntry.zeroCount, ones - strEntry.oneCount, index + 1, binCount);
            // We do NOT include the element in the knapsack
            int skipCount = knapsack(strs, zeroes, ones, index + 1, binCount);
            cache[index][zeroes][ones] = Math.max(addCount, skipCount);

            return cache[index][zeroes][ones];
        } else {
            // We cannot include the current element in the knapsack
            return knapsack(strs, zeroes, ones, index + 1, binCount);
        }
    }
}

class Entry {
    int oneCount;
    int zeroCount;

    Entry(int one, int zero) {
        this.oneCount = one;
        this.zeroCount = zero;
    }
}
