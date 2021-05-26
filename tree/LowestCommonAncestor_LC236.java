import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor_LC236 {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        lca(root, p, q);

        return ans;
    }

    // It is always important to complete the full traversal of the tree
    // Build from the bottom up
    private int lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        int l = lca(root.left, p, q);

        int r = lca(root.right, p, q);

        int curr = root.val == p.val || root.val == q.val ? 1 : 0;

        if ((l + r >= 2) && ans == null) {
            ans = root;
        }
        return l + r + curr;
    }

    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
/**
 * This is one of the most important question.
 * 
 * This algorithm would traverse the whole tree even if the given nodes are
 * found at the top. That's okay.
 * 
 * The clean template is that standing at a current node, we give back the total
 * of left + total of right + current. Assumably it is less than 2.
 * 
 * We can reuse this method in many other problems where the parent node gathers
 * information from it's left and right children, add it's own information and
 * pass it on to it's parent.
 * 
 * TC - O(N) SC - O(N)
 */
