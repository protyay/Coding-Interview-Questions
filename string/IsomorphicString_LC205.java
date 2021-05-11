import java.util.*;

public class IsomorphicString_LC205 {
    public boolean isIsomorphic(String s, String t) {
        // edgd // addd
        // Bijective mapping
        if (s.length() == 1)
            return true;
        int[] map = new int[129];
        int[] tMap = new int[129];
        Arrays.fill(map, -1);
        Arrays.fill(tMap, -1);

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            // Each char from S should map to exact one char of T
            if (map[curr] > -1 && map[curr] != t.charAt(i))
                return false;
            map[curr] = t.charAt(i);
            // Multiple chars from S shouldn't map to one char of T
            if (tMap[t.charAt(i)] > -1 && tMap[t.charAt(i)] != curr)
                return false;
            tMap[t.charAt(i)] = curr;
        }
        return true;
    }
}
/**
 * The concept of bijective mapping.

 */
