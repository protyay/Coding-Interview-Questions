import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BTMaxPathSum_LC124 {
    // SDE problem
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));

        max = Math.max(max, root.val + l + r);

        return root.val + Math.max(l, r);
    }
}

/**
 * [30,-10,-88,9,20,null,null] - This is a very interesting TC Understand the
 * concept of PATH in a tree. It's a continious connected paths. So, when we say
 * maximum path - at each node we can consider the L + R + NODE values Because
 * that can form a connected path. For the nodes in the upper level, we can
 * either consider the current level node + Max OF (L AND R). Because all three
 * nodes in the current level cannot be considered for the upper level path
 */
class Iterative_BTMaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.addFirst(root);
        Map<TreeNode, Integer> nodeSum = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        // At each node,
        while (!st.isEmpty()) {
            TreeNode top = st.getFirst();
            if (top.left != null && !nodeSum.containsKey(top.left))
                st.addFirst(top.left);
            else if (top.right != null && !nodeSum.containsKey(top.right))
                st.addFirst(top.right);
            else {
                top = st.removeFirst();
                int l = Math.max(0, nodeSum.getOrDefault(top.left, 0));
                int r = Math.max(0, nodeSum.getOrDefault(top.right, 0));

                int maxAtNode = Math.max(l, r) + top.val;
                maxSum = Math.max(maxSum, l + r + top.val);
                nodeSum.put(top, maxAtNode); // Store the max Path information for a node
            }
        }
        return maxSum;
    }
}
