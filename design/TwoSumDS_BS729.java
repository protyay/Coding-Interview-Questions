import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * SDE problem
 */
public class TwoSumDS_BS729 {
    private final Map<Integer, Integer> cache;

    public TwoSumDS_BS729() {
        this.cache = new HashMap<>();
    }

    public void add(int val) {
        this.cache.put(val, this.cache.getOrDefault(val, 0) + 1);
    }

    public boolean find(int val) {
        Set<Integer> keys = this.cache.keySet();
        for (int key : keys) {
            int to_find = val - key;
            if (to_find == key) {
                return this.cache.get(to_find) > 1;
            } else if (this.cache.containsKey(to_find))
                return true;
        }
        return false;
    }
}
/**
 * This is a nice implementation of Two_Sum problem
 * Two_sum and three Sum are most_important problem
 * 
 */
