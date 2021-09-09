import java.util.*;

public class ReorganizeStr_LC737 {
    public String reorganizeString(String S) {
        if (S == null || S.isEmpty() || S.length() == 1)
            return S;
        Queue<CharFreq> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        int[] freq = new int[26];
        int maxFreq = (int) Math.ceil(S.length() / 2.0);
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            freq[curr - 'a']++;
            if (freq[curr - 'a'] > maxFreq)
                return "";
        }
        // Add each char with their freq to HEAP
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            maxHeap.add(new CharFreq((char) ('a' + i), freq[i]));
        }
        StringBuilder res = new StringBuilder();
        while (maxHeap.size() > 1) {
            // Poll the most frequent two characters
            CharFreq mostFreq = maxHeap.remove();
            CharFreq secondFreq = maxHeap.remove();
            res.append(mostFreq.ch);
            res.append(secondFreq.ch);
            if (mostFreq.freq > 1)
                maxHeap.add(mostFreq.decreaseByOne());
            if (secondFreq.freq > 1)
                maxHeap.add(secondFreq.decreaseByOne());
        }
        while (!maxHeap.isEmpty()) {
            res.append(maxHeap.remove().ch);
        }
        return res.toString();
    }
}

class CharFreq {
    final char ch;
    final int freq;

    CharFreq(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    CharFreq decreaseByOne() {
        return new CharFreq(this.ch, this.freq - 1);
    }
}

/**
 * Key observation in this solution
 * 
 *The arrangement is defined by the most-frequent character 2.
 */
class ReorganizeStr_SimpleSolution {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        // This is actually very cool solution
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s= "brbsf";
        ReorganizeStr_SimpleSolution ss= new ReorganizeStr_SimpleSolution();
        String reorganized = ss.reorganizeString(s);
        System.out.println(reorganized);
    }
}
