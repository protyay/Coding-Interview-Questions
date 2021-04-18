public class LongestUnivaluePath_LC687 {
    int maxPathLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPathLen;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int left = 0, right = 0;
        if (root.left != null && root.left.val == root.val) {
            left += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right += r + 1;
        }
        maxPathLen = Math.max(maxPathLen, left + right);
        return Math.max(left, right);
    }
}

/**
 * The simple idea behind the problem is to aggregate the length from the L and R subtree
 * and return and add the info for the current node and pass it on to the parent.
 */
