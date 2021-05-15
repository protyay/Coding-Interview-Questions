
class SearchEngine_BS741 {
    TrieNode root;
    TrieNode nextValidNode = null;

    public SearchEngine_BS741() {
        root = new TrieNode();
    }

    public void add(String word) {
        if (word.isEmpty())
            return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.endCount++;
    }

    public boolean exists(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int idx, TrieNode node) {
        if (node == null)
            return false;
        if (idx == word.length())
            return node.endCount > 0;
        char c = word.charAt(idx);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(word, idx + 1, node.children[i]))
                    return true;
            }
        } else {
            if (search(word, idx + 1, node.children[c - 'a']))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchEngine_BS741 bs745 = new SearchEngine_BS741();
        bs745.add("doc");
        bs745.add("dog");
        bs745.add("wet");
        // System.out.println(bs745.exists("...."));
        // System.out.println(bs745.exists("do."));
        // System.out.println(bs745.exists("dog"));
        // System.out.println(bs745.exists("d.."));
        System.out.println(bs745.exists(".o."));
        // System.out.println(bs745.exists("..t"));
        // System.out.println(bs745.exists("..o"));
        // System.out.println(bs745.exists("do."));
        // System.out.println(bs745.exists("..g"));

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
