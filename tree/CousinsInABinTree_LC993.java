import java.util.ArrayDeque;
import java.util.Deque;

public class CousinsInABinTree_LC993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Deque<NodeEntry> q = new ArrayDeque<>();
        q.addLast(new NodeEntry(root, -1, 1));
        NodeEntry xNode = null, yNode = null;
        boolean allFound = false;
        while (!q.isEmpty()) {
            NodeEntry entry = q.removeFirst();
            if (entry.rootNode.val == x) {
                xNode = entry;
            } else if (entry.rootNode.val == y) {
                yNode = entry;
            }
            if (xNode != null && yNode != null) {
                allFound = true;
                break;
            }

            TreeNode rootNode = entry.rootNode;
            if (rootNode.left != null) {
                NodeEntry left = new NodeEntry(rootNode.left, rootNode.val, entry.level + 1);
                q.addLast(left);
            }
            if (rootNode.right != null) {
                NodeEntry right = new NodeEntry(rootNode.right, rootNode.val, entry.level + 1);
                q.addLast(right);
            }
        }
        // Handles the scenario where either one of the node is NOT present
        if (!allFound)
            return false;
        return xNode.parent != yNode.parent && xNode.level == yNode.level;
    }
}

class NodeEntry {
    TreeNode rootNode;
    int parent;
    int level;

    NodeEntry(TreeNode rootNode, int parent, int level) {
        this.rootNode = rootNode;
        this.parent = parent;
        this.level = level;
    }
}
