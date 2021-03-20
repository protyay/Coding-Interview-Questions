public class MapSumPairs_LC677 {
    TrieNode root = null;

    public MapSumPairs_LC677() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        if (key == null || key.isEmpty())
            return;
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        if (prefix == null || prefix.isEmpty())
            return 0;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null)
                return 0;
            node = node.children[c - 'a'];
        }
        return childSum(node);
    }

    private int childSum(TrieNode node) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sum += childSum(node.children[i]);
            }
        }
        sum += node.val;
        return sum;
    }

    class TrieNode {
        char ch;
        TrieNode[] children = new TrieNode[26];
        int val = 0;
        int endCount = 0;

        TrieNode() {

        }

        TrieNode(char currCh) {
            this.ch = currCh;
        }
    }
}
