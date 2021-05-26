import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal_LC144 {
    // SDE 
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return List.of();
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        fillNodes(root, stack, ans);

        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            fillNodes(node.right, stack, ans);

        }
        return ans;
    }

    private void fillNodes(TreeNode root, Deque<TreeNode> stack, List<Integer> ans) {
        while (root != null) {
            ans.add(root.val);
            stack.addFirst(root);
            root = root.left;
        }
    }

    /**
     * Recursive Implementation for Preorder traversal
     * 
     * @param root
     * @param nodes
     */
    private void walkPreOrder(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;

        nodes.add(root.val);
        walkPreOrder(root.left, nodes);
        walkPreOrder(root.right, nodes);
    }
}
