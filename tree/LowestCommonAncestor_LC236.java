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
/**
 * This is one of the most important question. 
 * 
 * This algorithm would traverse the whole tree even if the given nodes are found at the top. That's okay.
 * 
 * The clean template is that standing at a current node, we give back the total of left + total of right + current.
 * Assumably it is less than 2. 
 * 
 * We can reuse this method in many other problems where the parent node gathers information from it's left and right children,
 * add it's own information and pass it on to it's parent.
 * 
 * TC - O(N)
 * SC - O(N)
 */
