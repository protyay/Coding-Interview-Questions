import java.util.ArrayList;
import java.util.List;

public class WordSearchII_LC212 {
    private final List<String> res = new ArrayList<>();
    private int row = 0;
    private int col = 0;
    private final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null)
            return res;
        this.root = new TrieNode();

        for (String w : words) {
            addToTrie(w);
        }
        this.row = board.length;
        this.col = board[0].length;

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                dfs(board, i, j, "", this.root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, String str, TrieNode node) {

        if (!isInMatrix(r, c) || node == null || board[r][c] == '*')
            return;

        char letter = board[r][c];
        board[r][c] = '*';
        TrieNode endNode = node.nodes[letter - 'a'];

        if (endNode != null && endNode.isEnd) {
            endNode.isEnd = false;

            res.add(str + letter);
        }

        for (int[] dir : dirs) {
            int dx = r + dir[0];
            int dy = c + dir[1];

            dfs(board, dx, dy, str + letter, node.nodes[letter - 'a']);
        }
        board[r][c] = letter;
    }

    private boolean isInMatrix(int x, int y) {
        if (x < 0 || x >= this.row || y < 0 || y >= this.col)
            return false;
        return true;
    }

    private void addToTrie(String word) {
        TrieNode temp = this.root;
        for (char c : word.toCharArray()) {
            if (temp.nodes[c - 'a'] == null)
                temp.nodes[c - 'a'] = new TrieNode();
            temp = temp.nodes[c - 'a'];
        }
        temp.isEnd = true;
    }

    class TrieNode {
        TrieNode[] nodes;
        boolean isEnd;

        TrieNode() {
            this.nodes = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        //char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' } };
        //String[] words = { "oath", "pea", "eat", "rain" };

         char[][] board = { { 'a' } ,{'a'}};
         String[] words = { "aaa" };

        WordSearchII_LC212 lc212 = new WordSearchII_LC212();
        List<String> matched = lc212.findWords(board, words);
        System.out.println("Matched words =" + matched);
    }
}
