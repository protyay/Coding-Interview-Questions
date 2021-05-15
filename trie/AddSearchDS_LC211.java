public class AddSearchDS_LC211 {
    private TrieNode trie;

    public AddSearchDS_LC211() {
        this.trie = new TrieNode();
    }

    public void addWord(String word) {
        if (word.isEmpty())
            return;

        TrieNode root = trie;
        for (char c : word.toCharArray()) {
            if (root.nodes[c - 'a'] == null)
                root.nodes[c - 'a'] = new TrieNode();
            root = root.nodes[c - 'a'];
        }
        root.endWord++;
    }

    public boolean search(String word) {
        if (word.isEmpty())
            return false;
        return search(word, 0, this.trie);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (node == null)
            return false;
        if (index == word.length())
            return node.endWord > 0;

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(word, index + 1, node.nodes[i]))
                    return true;
            }
        } else {
            if (search(word, index + 1, node.nodes[c - 'a']))
                return true;
        }
        return false;
    }

    class TrieNode {
        TrieNode[] nodes;
        int endWord;

        TrieNode() {
            this.nodes = new TrieNode[26];
            this.endWord = 0;
        }
    }

    public static void main(String[] args) {
        AddSearchDS_LC211 lc211 = new AddSearchDS_LC211();
        lc211.addWord("dog");
        lc211.addWord("mad");
        lc211.addWord("mit");
        System.out.println("Is m.d found -->" + lc211.search("m.d"));
        System.out.println("Is m.. found -->" + lc211.search("m.."));
        System.out.println("Is mada found -->" + lc211.search("mada"));
    }

}
