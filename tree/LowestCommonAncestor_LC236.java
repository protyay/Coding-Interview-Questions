public class LowestCommonAncestor_LC236 {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        lca(root, p, q);

        return ans;
    }

    private int lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        int l = lca(root.left, p, q);

        int r = lca(root.right, p, q);

        int curr = root.val == p.val || root.val == q.val ? 1 : 0;

        if ((l + r == 2 || l + r + curr == 2) && ans == null) {
            ans = root;
            return 3;// Could be any arbit value greater than 2
        }
        return l + r + curr;
    }
}
