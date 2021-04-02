public class BTMaxPathSum_LC124 {
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
