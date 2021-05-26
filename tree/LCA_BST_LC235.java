public class LCA_BST_LC235 {
    // SDE problem
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (p.val > node.val && q.val > node.val)
                node = node.right;
            else if (p.val < node.val && q.val < node.val)
                node = node.left;
            else
                return node;
        }
        return null;
    }
}

/**
 * Determine the larger and the smaller among the nodes
 */
