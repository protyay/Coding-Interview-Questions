import java.util.HashMap;
import java.util.Map;

public class PairsOfSongs_LC1010 {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length == 1)
            return 0;
        Map<Integer, Integer> mod60 = new HashMap<>();
        int pair = 0;
        for (int t : time) {
            int mod = t % 60;
            if (mod == 0) {
                pair += mod60.getOrDefault(0, 0);
            } else {
                pair += mod60.getOrDefault(60 - mod, 0);
            }
            mod60.put(mod, mod60.getOrDefault(mod, 0) + 1);
        }
        return pair;
    }
}
