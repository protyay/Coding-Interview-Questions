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
