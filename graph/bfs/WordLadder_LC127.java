package bfs;

import java.util.*;

public class WordLadder_LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord))
            return 0;

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {

                String head = q.removeFirst();
                if (head.equals(endWord))
                    return level;

                transform(q, dic, head, visited);
            }
            ++level;
        }
        return 0;
    }

    private void transform(Deque<String> q, Set<String> dic, String head, Set<String> visited) {
        char[] ch = head.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            for (int j = 0; j < 26; j++) {
                ch[i] = (char) ('a' + j);
                String strNew = String.valueOf(ch);
                if (dic.contains(strNew) && !visited.contains(strNew)) {
                    visited.add(strNew);
                    q.addLast(strNew);
                }
            }
            ch[i] = temp;
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