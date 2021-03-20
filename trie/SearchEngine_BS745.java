
class SearchEngine_BS745 {
    TrieNode root;
    TrieNode nextValidNode = null;

    public SearchEngine_BS745() {
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
        return search(word.toCharArray(), 0, root.children);
    }

    private boolean search(char[] word, int idx, TrieNode[] node) {

        if (word[idx] == '.') {

            for (int i = 0; i < node.length; i++) {
                if (node[i] == null)
                    continue;

                if (idx == word.length - 1 && node[i].endCount > 0) {
                    return true;
                }
                return search(word, idx + 1, node[i].children);
            }

        } else {
            int charIdx = word[idx] - 'a';
            if (node[charIdx] == null)
                return false;
            if (idx == word.length - 1 && node[charIdx] != null && node[charIdx].endCount > 0)
                return true;
            return search(word, idx + 1, node[charIdx].children);
        }
        return false;
    }

    public static void main(String[] args) {
        SearchEngine_BS745 bs745 = new SearchEngine_BS745();
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
