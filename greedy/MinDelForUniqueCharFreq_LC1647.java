import java.util.Arrays;

public class MinDelForUniqueCharFreq_LC1647 {
    // SDE
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int del = 0;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0)
                continue;

            if (freq[i] == freq[i + 1]) {
                freq[i]--;
                ++del;
            } else {
                while (freq[i] > 0 && freq[i] >= freq[i + 1]) {
                    freq[i]--;
                    del++;
                }
            }
        }
        return del;
    }
}
/**
 * Once you sort the array, you start from the 2nd last index. Check if the freq
 * is equal to the next freq. Decrease 1. If the current freq is greater than
 * the next freq, we'll keep reducing the number until it is less than it's
 * right neighbour or less than zero, whichever is earlier. Return del count
 */
