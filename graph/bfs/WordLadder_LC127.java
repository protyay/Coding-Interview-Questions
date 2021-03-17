package bfs;

import java.util.*;

public class WordLadder_LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Deque<String> words = new ArrayDeque<>();
        Map<String, Boolean> visited = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++)
            visited.put(wordList.get(i), false);

        words.addLast(beginWord);
        visited.put(beginWord, true);
        int level = 1;

        while (!words.isEmpty()) {
            int len = words.size();
            while (len-- > 0) {
                String currWord = words.removeFirst();
                if (currWord.equals(endWord))
                    return level;
                findEdge(currWord, visited, words);
            }
            ++level;
        }
        return 0;
    }

    private void findEdge(String currWord, Map<String, Boolean> visited, Deque<String> words) {
        char[] ch = currWord.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ch = currWord.toCharArray();
            for (int k = 0; k < 26; k++) {
                ch[i] = (char) ('a' + k);
                String newStr = new String(ch);
                if (visited.containsKey(newStr) && !visited.get(newStr)) {
                    words.addLast(newStr);
                    visited.put(newStr, true);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> wordDic = Arrays.asList("hot", "dog");
        String beginWord = "hot", endWord = "dog";
        WordLadder_LC127 obj = new WordLadder_LC127();
        int level = obj.ladderLength(beginWord, endWord, wordDic);
        System.out.println(level);
    }
}