import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ValidateBST_LC98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return true;

        Deque<NodeInfo> stack = new ArrayDeque<>();
        stack.addFirst(new NodeInfo(root, null, null));
        Set<TreeNode> seen = new HashSet<>();

        while (!stack.isEmpty()) {
            NodeInfo top = stack.getFirst();

            if (top.node.left != null && !seen.contains(top.node.left))
                stack.addFirst(new NodeInfo(top.node.left, top.min, top.node.val));
            else if (top.node.right != null && !seen.contains(top.node.right))
                stack.addFirst(new NodeInfo(top.node.right, top.node.val, top.max));
            else {
                top = stack.removeFirst();
                seen.add(top.node);
                if (top.min != null && top.node.val <= top.min || top.max != null && top.node.val >= top.max)
                    return false;
            }
        }
        return true;
    }

    class NodeInfo {
        TreeNode node;
        Integer min;
        Integer max;

        NodeInfo(TreeNode node, Integer min, Integer max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}
