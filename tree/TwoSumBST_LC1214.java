import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TwoSumBST_LC1214 {
    private Map<Integer, Boolean> map = new HashMap<>();

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null)
            return false;

        Deque<TreeNode> stack = new ArrayDeque<>();

        fillNodes(stack, root1);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.removeFirst();
            fillNodes(stack, temp.right);
        }
        // Traverse the second subtree in ANY order and check for target - node.val
        return walkInOrder(root2, target);

    }

    private void fillNodes(Deque<TreeNode> stack, TreeNode root) {
        while (root != null) {
            map.put(root.val, true);
            stack.addFirst(root);
            root = root.left;
        }
    }

    private boolean walkInOrder(TreeNode root, int target) {
        if (root == null)
            return false;
        if (map.containsKey(target - root.val))
            return true;
        return walkInOrder(root.left, target) || walkInOrder(root.right, target);
    }
}
