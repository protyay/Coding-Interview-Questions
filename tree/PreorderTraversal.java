import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal_itertative(TreeNode root) {
        if (root == null)
            return List.of();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.addFirst(root);
        // Fill the stack with the root node
        while (!stack.isEmpty()) {
            TreeNode curTreeNode = stack.removeFirst();
            result.add(curTreeNode.val);

            if (curTreeNode.right != null)
                stack.addFirst(curTreeNode.right);
            if (curTreeNode.left != null)
                stack.addFirst(curTreeNode.left);
        }
        return result;
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
