
public class LongestWordinDic_LC720 {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        return t.dfs(t.root);
    }

    public static void main(String[] args) {
        LongestWordinDic_LC720 lc = new LongestWordinDic_LC720();
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        final String ans = lc.longestWord(words);
        System.out.println(ans);
    }
}

class TrieNode {
    char ch;
    TrieNode[] children;
    String endWord;

    public TrieNode() {
        children = new TrieNode[26];
        endWord = "";
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word.isEmpty())
            return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();

            node = node.children[c - 'a'];
        }
        node.endWord = word;
    }

    public String dfs(TrieNode root) {
        String res = root.endWord;
        for (TrieNode node : root.children) {
            if (node == null || node.endWord.isEmpty())
                continue;
            String childWord = dfs(node);
            if (childWord.length() > res.length())
                res = childWord;
        }
        return res;
    }
}
