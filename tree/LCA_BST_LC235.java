public class LCA_BST_LC235 {
    // SDE problem
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        // If one of P or Q is equal to the the root node, then we return
        if (p.val == root.val || q.val == root.val)
            return root;
        int smaller = Math.min(p.val, q.val);
        int larger = Math.max(p.val, q.val);
        if (smaller < root.val && larger > root.val)
            return root;

        else if (smaller < root.val && larger < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
/**
 * Determine the larger and the smaller among the nodes
 */
