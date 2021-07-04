import java.util.Arrays;

public class MinDelForUniqueCharFreq_LC1647 {
    // SDE
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);

        int del = 0, cutOff = freq[25] - 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0)
                continue;
            if (freq[i] > cutOff) {
                del += freq[i] - cutOff;
            }
            cutOff = Math.max(0, Math.min(freq[i] - 1, cutOff - 1));
        }
        return del;
    }
}
/**
 * Greedy problem because we keep the character with max freq. 
 * We keep reducing the number till we encounter zero.
 * 
 */
