import java.util.ArrayDeque;
import java.util.Deque;

public class CountGoodNodes_LC1448 {
    private int good = 0;

    public int goodNodes(TreeNode root) {
        if (root == null)
            return good;
        dfs(root, root.val);
        return good;
    }

    private void dfs(TreeNode root, int maxTillHere) {
        if (root == null)
            return;

        if (root.val >= maxTillHere)
            ++good;

        int max = Math.max(maxTillHere, root.val);

        dfs(root.left, max);
        dfs(root.right, max);
    }
}

class Iterative_GoodNodes {
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        // Max Stack can be applied here
        Deque<NodeInfo> stack = new ArrayDeque<>();
        stack.addFirst(new NodeInfo(root, root.val));
        int good = 1;
        while (!stack.isEmpty()) {
            NodeInfo top = stack.removeFirst();
            if (top.node.left != null) {
                if (top.node.left.val >= top.max)
                    ++good;
                stack.addFirst(new NodeInfo(top.node.left, Math.max(top.max, top.node.left.val)));
            }
            if (top.node.right != null) {
                if (top.node.right.val >= top.max)
                    ++good;
                stack.addFirst(new NodeInfo(top.node.right, Math.max(top.max, top.node.right.val)));
            }
        }
        return good;
    }

    class NodeInfo {
        TreeNode node;
        int max;

        NodeInfo(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }
}