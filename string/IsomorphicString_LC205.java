import java.util.*;

public class IsomorphicString_LC205 {
    public boolean isIsomorphic(String s, String t) {
        int[] charMap = new int[256];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        boolean[] mapped = new boolean[256];
        Arrays.fill(charMap, -1);

        for (int i = 0; i < sArr.length; i++) {
            // Violation of One-to-One Mapping
            if (charMap[(int) sArr[i]] != -1 && charMap[(int) sArr[i]] != tArr[i])
                return false;
            if (charMap[sArr[i]] == -1 && mapped[(int) tArr[i]])
                return false;

            mapped[(int) tArr[i]] = true;
            charMap[(int) sArr[i]] = tArr[i];
        }
        return true;
    }

}
