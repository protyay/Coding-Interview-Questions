import java.util.*;

public class CountBSTNodes_BS121 {
    int count = 0;

    public int solve(Tree root, int lo, int hi) {
        // We can simply generate the preorder traversal and count the nodes in it
        List<Integer> nodes = new ArrayList<>();
        buildNodes(root, nodes);
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) < lo || nodes.get(i) > hi)
                continue;
            ++count;
        }
        return count;
    }

    private void buildNodes(Tree root, List<Integer> nodes) {
        if (root == null)
            return;
        buildNodes(root.left, nodes);
        nodes.add(root.val);
        buildNodes(root.right, nodes);
    }
}

class Tree {
    int val;
    Tree left;
    Tree right;
}
