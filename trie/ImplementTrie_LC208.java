
public class ImplementTrie_LC208 {
    /** Initialize your data structure here. */
    TrieNode root;

    public ImplementTrie_LC208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.isEmpty())
            return;
        char[] ch = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < ch.length; i++) {
            int index = ch[i] - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.endCount++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.isEmpty())
            return false;
        TrieNode node = root;// Start searching from root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null)
                return false;
            node = node.children[ch - 'a'];
        }
        if (node.endCount > 0)
            return true;
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty())
            return false;
        TrieNode node = root;// Start searching from root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null)
                return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }

    class TrieNode {
        char ch;
        TrieNode[] children = new TrieNode[26];
        int endCount = 0;

        public TrieNode() {

        }

        public TrieNode(char currChar) {
            this.ch = currChar;
        }
    }
}
