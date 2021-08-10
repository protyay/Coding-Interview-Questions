import java.util.ArrayList;
import java.util.List;

public class WordSearchII_LC212 {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int childCount = 0;// Attach child count at each node
        String word = "";
        boolean endOfWord = false;

        public void addNode(String str) {
            TrieNode temp = this;
            for (char c : str.toCharArray()) {
                if (temp.children[c - 'a'] == null)
                    temp.children[c - 'a'] = new TrieNode();
                temp.childCount++;
                temp = temp.children[c - 'a'];
            }
            temp.endOfWord = true;
            temp.word = str;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            trie.addNode(word);
        }

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, trie, i, j, result, dir);
            }
        }
        return result;
    }

    private void search(char[][] board, TrieNode trie, int i, int j, List<String> result, int[][] dir) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == ' ' || trie.childCount == 0)
            return;

        char ch = board[i][j];
        TrieNode child = trie.children[ch - 'a'];
        if (child == null)
            return;

        if (child.word != null && !child.word.equals("")) {
            result.add(child.word);
            child.word = null;
        }

        board[i][j] = ' ';

        for (int[] d : dir) {
            search(board, child, i + d[0], j + d[1], result, dir);
        }

        board[i][j] = ch;
        if (child.childCount == 0) {
            trie.childCount--;
        }

    }

    public static void main(String[] args) {
        WordSearchII_LC212 sol = new WordSearchII_LC212();
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "pea", "eat" };
        List<String> matched = sol.findWords(board, words);
        System.out.println("Matched = " + matched);
    }
}
