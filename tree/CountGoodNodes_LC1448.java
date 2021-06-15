public class CountGoodNodes_LC1448 {
    private int good = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null)
            return good;
        dfs(root, root.val);
        return good;
    }

    private void dfs(TreeNode root, int maxTillHere) {
        if (root == null)
            return;

        if (root.val >= maxTillHere)
            ++good;

        int max = Math.max(maxTillHere, root.val);

        dfs(root.left, max);
        dfs(root.right, max);
    }
}
