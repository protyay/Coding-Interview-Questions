import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator_LC173 {
    // SDE
    private final Deque<TreeNode> stack;
    private TreeNode root;

    public BSTIterator_LC173(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        this.root = root;
        fillNodes(this.root, this.stack);
    }

    public int next() {
        if (this.stack.isEmpty())
            return -1;

        TreeNode top = this.stack.removeFirst();
        fillNodes(top.right, this.stack);

        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void fillNodes(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
/**
 * This is the optimal approach where in we are taking up O(H) case.
 * If we flatten the BST upfront , then that would have taken a total of O(N) space.
 * For very large tree which is balanced, this space difference would attribute a lot
 */
