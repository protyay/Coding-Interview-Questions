import java.util.ArrayDeque;
import java.util.Deque;

public class RangeSumBST_LC938 {
    // SDE Very important problem
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int sum = 0;

        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();

            if (L < node.val && node.left != null)
                stack.addFirst(node.left);
            if (R > node.val && node.right != null)
                stack.addFirst(node.right);

            if (L <= node.val && R >= node.val)
                sum += node.val;
        }
        return sum;
    }
}
