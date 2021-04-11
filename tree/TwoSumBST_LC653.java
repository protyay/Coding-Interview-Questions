import java.util.ArrayDeque;
import java.util.Deque;
/**
 * One of the rudimentary BST problem
 */
public class TwoSumBST_LC653 {
    public boolean findTarget(TreeNode root, int target) {
        if (root == null || (root.left == null && root.right == null))
            return false;
        Deque<TreeNode> left = new ArrayDeque<>();
        Deque<TreeNode> right = new ArrayDeque<>();

        fillLNodes(root, left);
        fillRNodes(root, right);

        while (!left.isEmpty() && !right.isEmpty() && left.getFirst() != right.getFirst()) {
            int sum = left.getFirst().val + right.getFirst().val;
            if (sum < target) {
                TreeNode topL = left.removeFirst();
                fillLNodes(topL.right, left);
            } else if (sum > target) {
                TreeNode topR = right.removeFirst();
                fillRNodes(topR.left, right);
            } else
                return true;
        }
        return false;
    }

    private void fillLNodes(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.addFirst(root);
            root = root.left;
        }

    }

    private static void fillRNodes(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.addFirst(root);
            root = root.right;
        }

    }
}
/**
 * One of the most important problems. 
 *
 */
