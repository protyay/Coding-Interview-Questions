import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestINBST_LC230 {
    // SDE // Repeat
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;

        Deque<TreeNode> stack = new ArrayDeque<>();
        int ans = 0;
        fillNodes(stack, root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            --k;
            if (k == 0) {
                ans = node.val;
                break;
            }
            fillNodes(stack, node.right);
        }
        return ans;

    }

    private void fillNodes(Deque<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
